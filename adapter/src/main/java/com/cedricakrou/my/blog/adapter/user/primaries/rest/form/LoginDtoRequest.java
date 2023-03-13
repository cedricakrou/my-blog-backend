package com.cedricakrou.my.blog.adapter.user.primaries.rest.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Logging a user Data Transfer Object Request.</p>
 *
 * @author KAKOU Akrou Cedric 2023-03-13
 */
@Getter
@AllArgsConstructor
public class LoginDtoRequest {

  String username;
  String password;
}
