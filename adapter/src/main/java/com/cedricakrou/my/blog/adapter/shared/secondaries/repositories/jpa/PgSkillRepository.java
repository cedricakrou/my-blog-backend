package com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.SkillEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Repository of skill.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Repository
public interface PgSkillRepository extends JpaRepository<SkillEntity, UUID> {

  /**
   * <p>Search a skill by name.</p>
   *
   * @param name name.
   * @return skill if it exists.
   */
  Optional<SkillEntity> findByName(String name);
}
