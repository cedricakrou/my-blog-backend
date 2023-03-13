package com.cedricakrou.library.helper.password;

/**
 * <p>Password Generator Interface.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
public interface PasswordGenerator {

  /**
   * <p>Generate a rand password.</p>
   *
   * @param strongPassword To decide if password
   *                       should be build based the PATTERN regex.
   * @param length         password length.
   * @return password.
   */
  String generateRandomPassword(boolean strongPassword, int length);

  /**
   * <p>Crypt password.</p>
   *
   * @param rawPassword password.
   * @return encrypted password.
   **/
  String crypt(String rawPassword);

  /**
   * <p>Decrypt password.</p>
   *
   * @param rawPassword       password.
   * @param encryptedPassword encrypted password.
   * @return result.
   **/
  boolean decrypt(String rawPassword, String encryptedPassword);
}
