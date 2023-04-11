package com.cedricakrou.library.security.jwt;

/**
 * <p>Jwt authentication contract.</p>
 *
 * @author KAKOU Akrou Cedric 2023-04-11
 */
public interface JwtAuthentication {

  /**
   * <p>Generate a jwt token.</p>
   *
   * @param username     username.
   * @param jwtSecretKey jwt Secret Key.
   * @param jwtDuration  jwt duration.
   * @return jwt token,
   */
  String generateToken(
          String username,
          String jwtSecretKey,
          long jwtDuration
  );

  /**
   * <p>Verify if token is valid.</p>
   *
   * @param token        token to verify.
   * @param jwtSecretKey jwt secret.
   * @return Map indicates true if token is valid or false and error message .
   */
  JwtVerificationResponse tokenIsValid(String token, String jwtSecretKey);


  /**
   * <p>Get username.</p>
   *
   * @param token        token
   * @param jwtSecretKey jwt secret.
   * @return username.
   */
  String getUsername(String token, String jwtSecretKey);
}
