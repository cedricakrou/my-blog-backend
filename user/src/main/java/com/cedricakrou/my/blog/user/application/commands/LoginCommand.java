package com.cedricakrou.my.blog.user.application.commands;

import com.cedricakrou.library.generic.aggregate.application.Command;
import lombok.Getter;

/**
 * <p>Comamnd of user login use case.</p>
 *
 * @author KAKOU Akrou Cedric 2023-02-15
 */
@Getter
public class LoginCommand implements Command {

  private final String username;
  private final String password;

  /**
   * <p>Default constructor.</p>
   *
   * @param username username.
   * @param password password.
   */
  public LoginCommand(final String username,
                      final String password) {
    this.username = username;
    this.password = password;
  }
}
