package com.cedricakrou.my.blog.user.application.playload;

import com.cedricakrou.library.generic.event.EventPayload;

/**
 * <p>Create User Event Payload.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-26
 */
public class CreateUserEventPayload implements EventPayload {

  private final String email;
  private final String password;

  /**
   * <p>Default constructor.</p>
   *
   * @param email    email.
   * @param password password.
   */
  public CreateUserEventPayload(final String email,
                                final String password) {
    this.email = email;
    this.password = password;
  }
}
