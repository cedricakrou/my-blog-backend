package com.cedricakrou.my.blog.user.domain.value.objects;

import com.cedricakrou.library.generic.aggregate.domain.ValueObject;

/**
 * <p>Value object representing User Tasks.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-07
 */
public class Task extends ValueObject {

  private final String text;

  /**
   * <p>constructor.</p>
   *
   * @param text    Text.
   * @param enabled enabled flag.
   * @param deleted deleted flag.
   */
  public Task(
          final String text,
          final boolean enabled,
          final boolean deleted) {
    super(enabled, deleted);
    this.text = text;
  }
}
