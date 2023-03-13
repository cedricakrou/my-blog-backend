package com.cedricakrou.library.generic.aggregate.application.exception;

/**
 * <p>Exception thrown when Object already exists.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
public class AlreadyExistsException extends Exception {

  /**
   * <p>Default constructor.</p>
   *
   * @param message Error message.
   */
  public AlreadyExistsException(final String message) {
    super(message);
  }
}
