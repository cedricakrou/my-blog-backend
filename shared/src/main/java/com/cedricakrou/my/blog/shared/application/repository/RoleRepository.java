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
   */
  Optional<Role> findRoleByName(String roleName);

}
