package com.cedricakrou.library.generic.aggregate.application.exception;

/**
 * <p>The exception throws when deserialize
 * or serialize object occurs an error.</p>
 *
 * @author KAKOU Akrou Cedric 2023-02-09
 */
public class ObjectStreamingException extends RuntimeException {

  /**
   * <p>Default constructor.</p>
   *
   * @param message message.
   */
  public ObjectStreamingException(final String message) {
    super(message);
  }
}
