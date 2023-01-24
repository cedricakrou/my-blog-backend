package com.cedricakrou.my.blog.user.application.usecases;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.library.helper.password.PasswordGenerator;
import com.cedricakrou.library.helper.password.PasswordGeneratorImpl;
import com.cedricakrou.my.blog.user.application.commands.CreateUserCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.UUID;
import java.util.logging.Logger;
import lombok.SneakyThrows;

/**
 * <p>Creating a new user Use Case.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
public class CreateUserUseCase implements UseCase<CreateUserCommand> {

  private final Logger logger =
          Logger.getLogger(CreateUserUseCase.class.getName());

  private final UserFacade userFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param userFacade User facade.
   */
  public CreateUserUseCase(final UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  /**
   * <p>Perform method.</p>
   *
   * @param command command of the use case.
   */
  @SneakyThrows
  @Override
  public void perform(final CreateUserCommand command) {

    command.checkValidity();

    String email = command.getEmail();
    String username = command.getUsername();

    if (userFacade.isUserCredentialsExists(email, username)) {
      throw new AlreadyExistsException(
              "User already exists with this username !"
      );
    }

    PasswordGenerator passwordGenerator = new PasswordGeneratorImpl();

    int passwordSize = 8;
    String password = passwordGenerator
            .generateRandomPassword(true, passwordSize);

    User user = new User.UserBuilder(
            UUID.randomUUID(),
            true,
            false)
            .setEmail(email)
            .setUsername(username)
            .setPassword(passwordGenerator.crypt(password))
            .buildEntity();

    this.userFacade.saveUser(user);

    this.logger.info("User created !");
  }
}
