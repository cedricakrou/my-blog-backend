package com.cedricakrou.my.blog.shared.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.Entity;
import java.util.UUID;

/**
 * <p>Entity representing a permission of role.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
public class Permission extends Entity {

  private final String name;
  private final String description;
  private final Role role;

  /**
   * <p>Constructor.</p>
   *
   * @param id          Id.
   * @param enabled     Enabled
   * @param deleted     Deleted.
   * @param name        Permission name.
   * @param description Permission description.
   * @param role        User Role.
   */
  public Permission(final UUID id,
                    final boolean enabled,
                    final boolean deleted,
                    final String name,
                    final String description,
                    final Role role
  ) {
    super(id, enabled, deleted);
    this.name = name;
    this.description = description;
    this.role = role;
  }
}
