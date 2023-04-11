package com.cedricakrou.library.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Jwt verification Response.</p>
 *
 * @author KAKOU Akrou Cedric 2023-04-11
 */
@Getter
@AllArgsConstructor
public class JwtVerificationResponse {

  private boolean status;
  private String message;

  /**
   * <p>Update message status.</p>
   *
   * @param message message.
   */
  public void message(final String message) {
    this.message = message;
  }
}
