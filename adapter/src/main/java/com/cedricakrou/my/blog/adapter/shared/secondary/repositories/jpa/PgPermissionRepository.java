package com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.PermissionEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Jpa repository of permmissions entity.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
public interface PgPermissionRepository extends
        JpaRepository<PermissionEntity, UUID> {

  /**
   * <p>Get by name.</p>
   *
   * @param name name.
   * @return permission entity or empty.
   */
  Optional<PermissionEntity> findByName(String name);
}
