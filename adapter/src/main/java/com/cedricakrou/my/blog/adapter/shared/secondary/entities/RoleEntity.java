package com.cedricakrou.my.blog.adapter.shared.secondary.entities;

import com.cedricakrou.library.generic.adapter.EntityRoot;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;

/**
 * <p>Entity Role.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Entity
@Table(name = "role")
@Getter
public class RoleEntity extends EntityRoot {

  @Column(name = "name", unique = true)
  private String name;
  @Column(name = "description")
  private String description;

  // TODO add permissions entities here.

  /**
   * <p>Secondary constructor.</p>
   *
   * @param id          Identifier.
   * @param enabled     Enabled.
   * @param deleted     Deleted.
   * @param name        name.
   * @param description description.
   */
  protected RoleEntity(final UUID id,
                       final boolean enabled,
                       final boolean deleted,
                       final String name,
                       final String description) {
    super(id, enabled, deleted);
    this.name = name;
    this.description = description;
  }

  /**
   * <p>Constructor without arguments.</p>
   */
  public RoleEntity() {
    super(null, false, false);
  }

  /**
   * <p>Create this entity from Role Domain.</p>
   *
   * @param role role domain.
   * @return Role Entity.
   */
  public static RoleEntity from(final Role role) {

    return new RoleEntity(
            role.getId(),
            role.isEnabled(),
            role.isDeleted(),
            role.getName(),
            role.getDescription()
            // TODO map permissions with permissions.
    );
  }

  /**
   * <p>Convert this entity to Role Domain.</p>
   *
   * @return Role.
   */
  public Role toDomain() {

    return new Role(
            UUID.randomUUID(),
            super.isEnabled(),
            super.isDeleted(),
            this.name,
            this.description,
            new Permission[]{});
  }
}
