package com.cedricakrou.my.blog.adapter.user.primaries.rest.form;

import lombok.Getter;

/**
 * <p>Creating a new user formula.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-24
 */
@Getter
public class CreateUserForm {

  private final String email;
  private final String username;

  /**
   * <p>Default constructor.</p>
   *
   * @param email    email.
   * @param username username.
   */
  public CreateUserForm(final String email,
                        final String username) {
    this.email = email;
    this.username = username;
  }
}
