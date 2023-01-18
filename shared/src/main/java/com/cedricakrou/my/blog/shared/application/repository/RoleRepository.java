package com.cedricakrou.my.blog.shared.application.repository;

import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.Optional;

/**
 * <p>Role repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public interface RoleRepository {

  /**
   * <p>Save a new role.</p>
   *
   * @param role the new role.
   */
  void save(Role role);

  /**
   * <p>find a role by name.</p>
   *
   * @param roleName the role name.
   * @return the role if it found.
   */
  Optional<Role> findByName(String roleName);

  /**
   * <p>Delete all role.</p>
   */
  void deleteAll();
}
