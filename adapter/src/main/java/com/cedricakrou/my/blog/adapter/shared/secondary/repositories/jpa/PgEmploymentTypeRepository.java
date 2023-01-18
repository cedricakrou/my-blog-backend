package com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.EmploymentTypeEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KAKOU Akrou Cedric 2023-01-18
 */
public interface PgEmploymentTypeRepository extends
        JpaRepository<EmploymentTypeEntity, UUID> {
  /**
   * <p>Get employment type by name.</p>
   *
   * @param name name.
   * @return EmploymentTypeEntity.
   */
  Optional<EmploymentTypeEntity> findByName(String name);
}
