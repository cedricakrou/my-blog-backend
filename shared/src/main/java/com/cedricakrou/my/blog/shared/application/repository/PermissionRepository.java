package com.cedricakrou.my.blog.shared.application.repository;

import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import java.util.Optional;

/**
 * <p>Permission repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public interface PermissionRepository {

  /**
   * <p>Save a new permission.</p>
   *
   * @param permission the new permission.
   */
  void save(Permission permission);

  /**
   * <p>find a permission by name.</p>
   *
   * @param roleName the permission name.
   * @return the permission if it found.
   */
  Optional<Permission> findByName(String roleName);

  /**
   * <p>Delete all permission.</p>
   */
  void deleteAll();
}
