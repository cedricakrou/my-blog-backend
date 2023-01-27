package com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.PermissionEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Jpa repository of permmissions entity.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Repository
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
