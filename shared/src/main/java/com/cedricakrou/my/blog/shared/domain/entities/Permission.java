package com.cedricakrou.my.blog.shared.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.DomainEntityRoot;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Entity representing a permission of role.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
@Getter
public class Permission extends DomainEntityRoot {

  private final String name;
  private final String description;
  private final Role[] roles;

  /**
   * <p>Constructor.</p>
   *
   * @param id          Id.
   * @param enabled     Enabled
   * @param deleted     Deleted.
   * @param name        Permission name.
   * @param description Permission description.
   * @param roles        User Role.
   */
  public Permission(final UUID id,
                    final boolean enabled,
                    final boolean deleted,
                    final String name,
                    final String description,
                    final Role[] roles
  ) {
    super(id, enabled, deleted);
    this.name = name;
    this.description = description;
    this.roles = roles;
  }
}
