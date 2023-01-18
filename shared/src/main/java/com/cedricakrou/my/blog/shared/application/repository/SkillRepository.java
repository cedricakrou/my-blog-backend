package com.cedricakrou.my.blog.shared.application.repository;

import com.cedricakrou.my.blog.shared.domain.entities.Skill;
import java.util.Optional;

/**
 * <p>Skill repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
public interface SkillRepository {

  /**
   * <p> Get Skill by name.</p>
   *
   * @param name name.
   * @return skill or empty.
   */
  Optional<Skill> findByName(String name);

  /**
   * <p> Add skill.</p>
   *
   * @param skill skill.
   */
  void save(Skill skill);
}
