package com.cedricakrou.my.blog.shared.application.service;

import com.cedricakrou.my.blog.shared.domain.entities.Skill;
import java.util.Optional;

/**
 * <p>Service of {@link Skill}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
public interface SkillService {

  /**
   * <p> Get Skill by name.</p>
   *
   * @param name name.
   * @return skill or empty.
   */
  Optional<Skill> findSkillByName(String name);

  /**
   * <p> Add skill.</p>
   *
   * @param skill skill.
   */
  void addSkill(Skill skill);
}
