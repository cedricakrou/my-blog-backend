package com.cedricakrou.library.generic.aggregate.application;

/**
 * @author KAKOU Akrou Cedric 2023-03-03
 */
public interface UseCaseQuery<T extends Command, R> {

  /**
   * <p>Main method for drawing up the UseCaseQuery.</p>
   *
   * @param command command of the use case.
   */
  R perform(T command);
}
