package com.cedricakrou.my.blog.adapter.shared.primary.rest.vm;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.SkillEntity;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>View model for Skill.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
@Getter
public class SkillVm {
  private final UUID id;
  private final String name;
  private final String description;

  /**
   * <p>Default constructor.</p>
   *
   * @param skillEntity role entity.
   */
  public SkillVm(final SkillEntity skillEntity) {
    this.id = skillEntity.getId();
    this.name = skillEntity.getName();
    this.description = skillEntity.getDescription();
  }
}
