package com.cedricakrou.my.blog.shared.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.DomainEntityRoot;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Entity representing User Role.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
@Getter
public class Role extends DomainEntityRoot {

  private final String name;
  private String description;
  private Permission[] permissions;

  /**
   * <p>Constructor.</p>
   *
   * @param id          Id.
   * @param enabled     Enabled
   * @param deleted     Deleted.
   * @param name        Permission name.
   * @param description Permission description.
   * @param permissions permissions bound this role.
   */
  public Role(final UUID id,
              final boolean enabled,
              final boolean deleted,
              final String name,
              final String description,
              final Permission[] permissions) {
    super(id, enabled, deleted);
    this.name = name;
    this.description = description;
    this.permissions = permissions;
  }

  /**
   * <p> Second Constructor.</p>
   *
   * @param id      Id.
   * @param enabled Enabled
   * @param deleted Deleted.
   * @param name    Permission name.
   */
  public Role(
          final UUID id,
          final boolean enabled,
          final boolean deleted,
          final String name
  ) {
    super(id, enabled, deleted);
    this.name = name;
  }
}
