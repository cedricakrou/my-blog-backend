package com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.RoleEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Jpa Role repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Repository
public interface PgRoleRepository extends JpaRepository<RoleEntity, UUID> {

  /**
   * <p>Find a role by his name.</p>
   *
   * @param roleName role name.
   * @return role entity or empty.
   */
  Optional<RoleEntity> findByName(String roleName);
}
