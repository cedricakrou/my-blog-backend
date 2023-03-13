package com.cedricakrou.my.blog.shared.application.service;

import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import java.util.Optional;

/**
 * <p>Permission service.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
public interface PermissionService {
  /**
   * <p>Get permission by name.</p>
   *
   * @param name name.
   * @return permission or empty.
   */
  Optional<Permission> findPermissionByName(String name);

  /**
   * <p>Add permission.</p>
   *
   * @param permission permission.
   */
  void addPermission(Permission permission);
}
