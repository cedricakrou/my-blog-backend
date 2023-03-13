package com.cedricakrou.my.blog.user.domain.value.objects;

import com.cedricakrou.library.generic.aggregate.domain.ValueObject;
import java.util.UUID;

/**
 * <p>Value Object representing Employment Type.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-07
 */
public class EmploymentType extends ValueObject {

  private final UUID id;
  private final String label;

  /**
   * <p>constructor.</p>
   *
   * @param id      Identifier.
   * @param label   Label.
   * @param enabled enabled flag.
   * @param deleted deleted flag.
   */
  public EmploymentType(
          final UUID id,
          final String label,
          final boolean enabled,
          final boolean deleted) {
    super(enabled, deleted);
    this.id = id;
    this.label = label;
  }
}
