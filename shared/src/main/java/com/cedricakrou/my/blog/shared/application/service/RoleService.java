package com.cedricakrou.my.blog.shared.application.service;

import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.Optional;

/**
 * <p>Role service.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public interface RoleService {

  /**
   * <p>Get the role by his name.</p>
   *
   * @param roleName role name.
   * @return role.
   */
  Optional<Role> findRoleByName(String roleName);

  /**
   * <p>Add a role.</p>
   *
   * @param role role.
   */
  void addRole(Role role);

  /**
   * <p>Delete all role.</p>
   */
  void deleteAll();
}
