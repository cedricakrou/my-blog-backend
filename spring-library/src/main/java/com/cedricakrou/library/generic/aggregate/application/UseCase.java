package com.cedricakrou.library.generic.aggregate.application;

/**
 * <p>Scope for all Use Cases.</p>
 *
 * @param <T> Use Case Command.
 * @author KAKOU Akrou Cedric 2023-01-09
 */
public interface UseCase<T extends Command> {

  /**
   * <p>Main method for drawing up the UseCase.</p>
   *
   * @param command command of the use case.
   */
  void perform(T command);
}
