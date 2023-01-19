package com.cedricakrou.my.blog.adapter.shared.primary.rest.vm;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.PermissionEntity;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>View model of permission.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
@Getter
public class PermissionVm {

  private final UUID id;
  private final String name;
  private final String description;

  /**
   * <p>Default constructor.</p>
   *
   * @param permissionEntity permission entity.
   */
  public PermissionVm(final PermissionEntity permissionEntity) {
    this.id = permissionEntity.getId();
    this.name = permissionEntity.getName();
    this.description = permissionEntity.getDescription();
  }
}
