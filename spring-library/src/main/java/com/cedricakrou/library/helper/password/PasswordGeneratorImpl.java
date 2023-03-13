package com.cedricakrou.library.helper.password;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

/**
 * <p>Implementation of password Generator.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
public class PasswordGeneratorImpl implements PasswordGenerator {

  public static final String STRONG_PASSWORD_REGEX =
"/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$/";

  /**
   * <p>Build random password.</p>
   *
   * @param strongPassword To decide if password
   *                       should be build based the PATTERN regex.
   * @param length         password length.
   * @return password generated.
   */
  @Override
  public String generateRandomPassword(final boolean strongPassword,
                                       final int length) {
    return "TestPassword3#"; // TODO implement real code.
  }

  /**
   * <p>Crypt password.</p>
   *
   * @param rawPassword password.
   * @return password encrypted.
   */
  @Override
  public String crypt(final String rawPassword) {
    return hashPassword(rawPassword);
  }

  /**
   * <p>decrypt password.</p>
   *
   * @param rawPassword       password.
   * @param encryptedPassword encrypted password.
   * @return true if hashed password == encrypted password.
   */
  @Override
  public boolean decrypt(final String rawPassword,
                         final String encryptedPassword) {

    String hashPassword = hashPassword(rawPassword);

    return hashPassword.equals(encryptedPassword);
  }

  /**
   * <p>Hash password.</p>
   *
   * @param rawPassword raw password.
   * @return hashed password.
   */
  private String hashPassword(final String rawPassword) {

    return Hashing.sha256()
            .hashString(rawPassword, StandardCharsets.UTF_8)
            .toString();
  }
}
