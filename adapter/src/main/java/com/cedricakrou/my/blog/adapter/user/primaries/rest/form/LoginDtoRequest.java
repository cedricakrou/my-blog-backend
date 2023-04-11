package com.cedricakrou.my.blog.adapter.user.primaries.rest.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Logging a user Data Transfer Object Request.</p>
 *
 * @author KAKOU Akrou Cedric 2023-03-13
 */
@Getter
@Setter
@AllArgsConstructor
public class LoginDtoRequest {

  private final String username;
  private final String password;
}
