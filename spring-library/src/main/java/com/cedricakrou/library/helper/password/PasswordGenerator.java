package com.cedricakrou.library.helper.password;

/**
 * <p>Password Generator Interface.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
public interface PasswordGenerator {

  /**
   * <p>Generate a new password.</p>
   *
   * @param strongPassword To decide if password
   *                       should be build based the PATTERN regex.
   * @param length         password length.
   * @return password.
   */
  String execute(boolean strongPassword, int length);
}
