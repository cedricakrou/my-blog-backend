package com.cedricakrou.library.generic.aggregate.domain;

/**
 * <p>Class that designates the utility classes.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
public class ValueObject extends CommonProperties {

  /**
   * <p>constructor.</p>
   *
   * @param enabled enabled flag.
   * @param deleted deleted flag.
   */
  public ValueObject(final boolean enabled, final boolean deleted) {
    super(enabled, deleted);
  }
}
