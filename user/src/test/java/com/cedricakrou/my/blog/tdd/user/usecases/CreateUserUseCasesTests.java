package com.cedricakrou.my.blog.tdd.user.usecases;

import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.tdd.user.facade.UserFacadeImpl;
import com.cedricakrou.my.blog.user.application.commands.CreateUserCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.application.usecases.CreateUserUseCase;
import com.cedricakrou.my.blog.user.domain.entities.User;
import com.cedricakrou.my.blog.user.domain.event.CreateUserEvent;
import com.cedricakrou.my.blog.tdd.user.event.CreateUserEventImpl;
import java.util.Optional;
import java.util.UUID;
import javax.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <p>Test of {@link CreateUserUseCase}</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
@ExtendWith(MockitoExtension.class)
class CreateUserUseCasesTests {

  private UserRepository userRepository;
  private CreateUserUseCase createUserUseCase;

  @BeforeEach
  void setUp() {
    this.userRepository = Mockito.mock(UserRepository.class);
    UserFacade userFacade = new UserFacadeImpl(this.userRepository);
    CreateUserEvent createUserEvent = new CreateUserEventImpl();
    this.createUserUseCase = new CreateUserUseCase(userFacade, createUserEvent);
  }

  @Test
  void createUser_shouldFailedWhenEmailIsEmpty() {

    CreateUserCommand command = new CreateUserCommand(
            "",
            "Username"
    );

    Exception exception = Assertions.assertThrows(
            ConstraintViolationException.class,
            () -> this.createUserUseCase.perform(command)
    );

    Assertions.assertEquals(
            "email: email is mandatory !",
            exception.getMessage());
  }

  @Test
  void createUser_shouldFailedWhenEmailIsInvalid() {

    CreateUserCommand command = new CreateUserCommand(
            "cedricakrou",
            "Username"
    );

    Exception exception = Assertions.assertThrows(
            ConstraintViolationException.class,
            () -> this.createUserUseCase.perform(command)
    );

    Assertions.assertEquals(
            "email: Insert a correct email !",
            exception.getMessage());
  }

  @Test
  void createUser_shouldFailedWhenUsernameIsEmpty() {

    CreateUserCommand command = new CreateUserCommand(
            "cedriakrou@gmail.com",
            ""
    );

    Exception exception = Assertions.assertThrows(
            ConstraintViolationException.class,
            () -> this.createUserUseCase.perform(command)
    );


    Assertions.assertNotNull(exception);
  }

  @Test
  void createUser_shouldFailedWhenUsernameSizeIsLesserThan3() {

    CreateUserCommand command = new CreateUserCommand(
            "cedriakrou@gmail.com",
            "si"
    );

    Exception exception = Assertions.assertThrows(
            ConstraintViolationException.class,
            () -> this.createUserUseCase.perform(command)
    );

    Assertions.assertEquals(
            "username: username must have at least 3 characters !",
            exception.getMessage());
  }

  @Test
  void createUser_shouldSucceed() {

    CreateUserCommand command = new CreateUserCommand(
            "cedriakrou@gmail.com",
            "cedricakrou"
    );

    this.createUserUseCase.perform(command);

    Mockito.verify(this.userRepository).save(Mockito.any(User.class));
  }

  @Test
  void createUser_shouldFailedWhenUsernameAlreadyOrUsername() {

    String email = "cedricakrou@gmail.com";
    String username = "cedricakrou";

    CreateUserCommand command = new CreateUserCommand(
            email,
            username
    );

    User user = new User
            .UserBuilder(UUID.randomUUID(), true, false)
            .setUsername(username)
            .setEmail(email)
            .buildEntity();

    Mockito.when(this.userRepository.findByEmailOrUsername(email, username)).thenReturn(Optional.of(user));

    Exception exception = Assertions.assertThrows(
            AlreadyExistsException.class,
            () -> this.createUserUseCase.perform(command)
    );

    Assertions.assertEquals(
            "User already exists with this username !",
            exception.getMessage());
  }


}
