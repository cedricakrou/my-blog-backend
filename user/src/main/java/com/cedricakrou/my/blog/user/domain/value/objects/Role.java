package com.cedricakrou.my.blog.user.domain.value.objects;

import com.cedricakrou.library.generic.aggregate.ValueObject;
import java.util.UUID;

/**
 * <p>Value object representing Role of User.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
public class Role extends ValueObject {
  private final UUID id;
  private final String name;

  /**
   * <p>Initialize object with this constructor.</p>
   *
   * @param id      Identifier.
   * @param name    name.
   * @param enabled enabled.
   * @param deleted deleted.
   */
  public Role(final UUID id,
              final String name,
              final boolean enabled,
              final boolean deleted) {
    super(enabled, deleted);
    this.id = id;
    this.name = name;
  }
}
