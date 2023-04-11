package com.cedricakrou.library.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;

/**
 * <p>Implementation of {@link JwtAuthentication}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-04-11
 */
public class JwtAuthenticationImpl implements JwtAuthentication {


  @Value("${jwt.issuer.name}")
  private String issuer;

  /**
   * <p>Generate token.</p>
   *
   * @param username     username.
   * @param jwtSecretKey jwt Secret Key.
   * @param jwtDuration  jwt duration.
   * @return token.
   */
  @Override
  public String generateToken(final String username,
                              final String jwtSecretKey,
                              final long jwtDuration) {

    return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
            .setSubject(String.format("%s", username))
            .setIssuer(issuer)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtDuration))
            .compact();
  }


  /**
   * <p>Verify if token is valid.</p>
   *
   * @param token        token to verify.
   * @param jwtSecretKey jwt secret.
   * @return Map indicates true if token is valid or false and error message .
   */
  @Override
  public JwtVerificationResponse tokenIsValid(final String token,
                                              final String jwtSecretKey) {

    JwtVerificationResponse jwtVerificationResponse =
            new JwtVerificationResponse(false, "");

    try {
      Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJwt(token);

      return new JwtVerificationResponse(true, "");
    } catch (ExpiredJwtException ex) {

      jwtVerificationResponse.message("JWT expired");
    } catch (IllegalArgumentException ex) {

      jwtVerificationResponse.message(
              "Token is null, empty or only whitespace");
    } catch (MalformedJwtException ex) {

      jwtVerificationResponse.message("JWT is invalid");
    } catch (UnsupportedJwtException ex) {

      jwtVerificationResponse.message("JWT is not supported");
    } catch (SignatureException ex) {

      jwtVerificationResponse.message("Signature validation failed");
    }

    return jwtVerificationResponse;
  }

  /**
   * <p>Get username.</p>
   *
   * @param token        token
   * @param jwtSecretKey jwt secret.
   * @return username.
   */
  @Override
  public String getUsername(final String token,
                            final String jwtSecretKey) {

    return Jwts.parser().setSigningKey(jwtSecretKey)
            .parseClaimsJwt(token)
            .getBody()
            .getSubject();
  }
}
