package com.cedricakrou.my.blog.adapter.shared.primary.rest.vm;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.RoleEntity;
import java.util.UUID;
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

  /**
   * <p>Default constructor.</p>
   *
   * @param roleEntity role entity.
   */
  public RoleVm(final RoleEntity roleEntity) {
    this.id = roleEntity.getId();
    this.name = roleEntity.getName();
    this.description = roleEntity.getDescription();
  }
}
