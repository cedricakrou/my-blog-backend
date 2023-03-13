package com.cedricakrou.my.blog.user.application.usecases;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.library.generic.event.EventManager;
import com.cedricakrou.library.helper.password.PasswordGenerator;
import com.cedricakrou.library.helper.password.PasswordGeneratorImpl;
import com.cedricakrou.my.blog.user.application.commands.CreateUserCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.domain.entities.User;
import com.cedricakrou.my.blog.user.application.playload.CreateUserEventPayload;
import com.cedricakrou.my.blog.user.domain.event.CreateUserEvent;
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
  private final EventManager<CreateUserEventPayload> eventManager;

  /**
   * <p>Default constructor.</p>
   *
   * @param userFacade User facade.
   * @param eventManager Create User Event.
   */
  public CreateUserUseCase(final UserFacade userFacade,
                           final CreateUserEvent eventManager) {
    this.userFacade = userFacade;
    this.eventManager = eventManager;
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

    this.eventManager.publish(
            new CreateUserEventPayload(
                    email,
                    password
            )
    );

    // TODO send event sourcing event

    this.logger.info("User created !");
  }
}
