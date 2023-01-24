package com.cedricakrou.library.helper.password;

/**
 * <p>Implementation of password Generator.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
public class PasswordGeneratorImpl implements PasswordGenerator {

  public static final String STRONG_PASSWORD_REGEX =
"/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$/";

  /**
   * <p>Build password.</p>
   *
   * @param strongPassword To decide if password
   *                       should be build based the PATTERN regex.
   * @param length         password length.
   * @return password generated.
   */
  @Override
  public String execute(final boolean strongPassword, final int length) {
    return "TestPassword3#"; // TODO implement real code.
  }
}
