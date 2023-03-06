package com.cedricakrou.my.blog.user.application.usecases;

import com.cedricakrou.library.generic.aggregate.application.UseCaseQuery;
import com.cedricakrou.library.generic.aggregate.application.exception.NotFoundException;
import com.cedricakrou.library.generic.aggregate.application.exception.UserConnectionException;
import com.cedricakrou.my.blog.user.application.commands.LoginCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.Optional;
import java.util.logging.Logger;
import lombok.SneakyThrows;

/**
 * <p>Login Use Case.</p>
 *
 * @author KAKOU Akrou Cedric 2023-02-15
 */
public class LoginUseCase implements UseCaseQuery<LoginCommand, String> {

  private final Logger logger = Logger.getLogger(LoginUseCase.class.getName());
  private final UserFacade userFacade;

  public LoginUseCase(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  @SneakyThrows
  @Override
  public String perform(LoginCommand command) {

    String username = command.getUsername();
    String password = command.getPassword();

    Optional<User> optionalUser = this.userFacade.findUserByUsername(username);

    if (optionalUser.isEmpty()) {

      throw new NotFoundException("Utilisateur non trouvé !");
    }

    User user = optionalUser.get();

    if (!password.equals(user.getPassword())) {

      throw new UserConnectionException("Mot de passe incorrect !");
    }

    User userToUpdate = new User.UserBuilder(user)
            .setLoggedIn(true)
            .buildEntity();


    this.userFacade.saveUser(userToUpdate);

    this.logger.info("Utilisateur connecté !");

    return this.userFacade.createToken(user);
  }
}
