package com.cedricakrou.library.generic.aggregate.application.exception;

/**
 * <p>Exception thrown when problems occur when he want to connect.</p>
 *
 * @author KAKOU Akrou Cedric 2023-03-03
 */
public class UserConnectionException extends Exception {

  /**
   * <p>Default constructor.</p>
   *
   * @param message Error message.
   */
  public UserConnectionException(final String message) {
    super(message);
  }
}
