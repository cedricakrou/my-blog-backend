package com.cedricakrou.my.blog.adapter.shared.secondaries.entities;

import com.cedricakrou.library.generic.adapter.DatabaseEntityRoot;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;

/**
 * <p>Entity Role.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Entity
@Table(name = "permission")
@Getter
public class PermissionEntity extends DatabaseEntityRoot<Permission> {

  @Column(name = "name", unique = true)
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "roles")
  @ManyToMany
  private List<RoleEntity> roles;

  /**
   * <p>Secondary constructor.</p>
   *
   * @param id          Identifier.
   * @param enabled     Enabled.
   * @param deleted     Deleted.
   * @param name        name.
   * @param description description.
   * @param roles       roles.
   */
  protected PermissionEntity(final UUID id,
                             final boolean enabled,
                             final boolean deleted,
                             final String name,
                             final String description,
                             final List<RoleEntity> roles) {
    super(id, enabled, deleted);
    this.name = name;
    this.description = description;
    this.roles = roles;
  }

  /**
   * <p>Constructor without arguments.</p>
   */
  public PermissionEntity() {
    super(null, false, false);
  }

  /**
   * <p>Create this entity from Permission Domain.</p>
   *
   * @param permission domain.
   * @return Permission Entity.
   */
  public static PermissionEntity from(final Permission permission) {

    return new PermissionEntity(
            permission.getId(),
            permission.isEnabled(),
            permission.isDeleted(),
            permission.getName(),
            permission.getDescription(),
            Arrays.stream(permission.getRoles())
                    .map(RoleEntity::from)
                    .collect(Collectors.toList())
    );
  }

  /**
   * <p>Convert this entity to Role Domain.</p>
   *
   * @return Permission.
   */
  public Permission toDomain() {

    return new Permission(
            UUID.randomUUID(),
            super.isEnabled(),
            super.isDeleted(),
            this.name,
            this.description,
            this.roles.stream().map(it ->
                    new Role(it.getId(),
                            it.isEnabled(),
                            it.isDeleted(),
                            it.getName())
            ).toArray(Role[]::new)
    );
  }
}
