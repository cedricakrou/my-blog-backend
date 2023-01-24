package com.cedricakrou.my.blog.user.application.commands;

import com.cedricakrou.library.generic.aggregate.application.Command;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;

/**
 * <p>Command of User crating Use Case.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
@Getter
public class CreateUserCommand implements Command {

  @NotEmpty(message = "username is mandatory !")
  @Size(min = 3, message = "username must have at least 3 characters !")
  private final String username;

  @Email(message = "Insert a correct email !")
  @NotEmpty(message = "email is mandatory !")
  private final String email;

  /**
   * <p>Default constructor.</p>
   *
   * @param email    email.
   * @param username username.
   */
  public CreateUserCommand(final String email, final String username) {
    this.email = email;
    this.username = username;
  }
}
