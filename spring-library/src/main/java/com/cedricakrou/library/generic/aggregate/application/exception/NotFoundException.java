package com.cedricakrou.library.generic.aggregate.application.exception;

/**
 * <p>Exception thrown when Object is unknown.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
public class NotFoundException extends Exception {

  /**
   * <p>Default constructor.</p>
   *
   * @param message Error message.
   */
  public NotFoundException(final String message) {
    super(message);
  }
}
