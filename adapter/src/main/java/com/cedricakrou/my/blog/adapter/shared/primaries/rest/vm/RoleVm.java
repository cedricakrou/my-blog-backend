package com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.RoleEntity;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * <p>View model for Role.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
@Getter
public class RoleVm {
  private final UUID id;
  private final String name;
  private final String description;
  private final List<PermissionVm> permissions;

  /**
   * <p>Default constructor.</p>
   *
   * @param roleEntity role entity.
   */
  public RoleVm(final RoleEntity roleEntity) {
    this.id = roleEntity.getId();
    this.name = roleEntity.getName();
    this.description = roleEntity.getDescription();
    this.permissions = roleEntity.getPermissions()
            .stream()
            .map(PermissionVm::new)
            .collect(Collectors.toList());
  }
}
