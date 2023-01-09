package com.cedricakrou.library.generic.aggregate.domain;

import lombok.Getter;

/**
 * <p>Common properties.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
@Getter
public class CommonProperties {
  private final boolean enabled;
  private final boolean deleted;

  /**
   * <p>Constructor.</p>
   *
   * @param enabled enabled flag.
   * @param deleted deleted flag.
   */
  public CommonProperties(final boolean enabled, final boolean deleted) {
    this.enabled = enabled;
    this.deleted = deleted;
  }
}
