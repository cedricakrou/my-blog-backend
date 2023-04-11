package com.cedricakrou.library.generic.aggregate.application;

/**
 * <p>Scope for all command of Use Cases queries.</p>
 *
 * @param <T> Command
 * @param <R> value you want to return.
 * @author KAKOU Akrou Cedric 2023-03-03.
 */
public interface UseCaseQuery<T extends Command, R> {

  /**
   * <p>Main method for drawing up the UseCaseQuery.</p>
   *
   * @param command command of the use case.
   * @return <R> value you want to return.
   */
  R perform(T command);
}
