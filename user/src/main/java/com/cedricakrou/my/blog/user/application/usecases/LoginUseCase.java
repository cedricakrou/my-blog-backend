package com.cedricakrou.my.blog.user.application.usecases;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.my.blog.user.application.commands.LoginCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import java.util.logging.Logger;

/**
 * <p>Login Use Case.</p>
 *
 * @author KAKOU Akrou Cedric 2023-02-15
 */
public class LoginUseCase implements UseCase<LoginCommand> {

  private static final Logger LOG = Logger.getLogger(LoginUseCase.class.getName());
  private UserFacade userFacade;

  public LoginUseCase(
          UserFacade userFacade
  ) {
    this.userFacade = userFacade;
  }

  @Override
  public void perform(LoginCommand command) {

  }
}
