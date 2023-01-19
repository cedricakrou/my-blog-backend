package com.cedricakrou.my.blog.adapter.shared.secondary.entities;

import com.cedricakrou.library.generic.adapter.EntityRoot;
import com.cedricakrou.my.blog.shared.domain.entities.Skill;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;

/**
 * <p>Entity Skill.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Entity
@Table(name = "skill")
@Getter
public class SkillEntity extends EntityRoot {

  @Column(name = "name", unique = true)
  private String name;
  @Column(name = "description")
  private String description;

  /**
   * <p>Secondary constructor.</p>
   *
   * @param id          Identifier.
   * @param enabled     Enabled.
   * @param deleted     Deleted.
   * @param name        name.
   * @param description description.
   */
  protected SkillEntity(final UUID id,
                        final boolean enabled,
                        final boolean deleted,
                        final String name,
                        final String description) {
    super(id, enabled, deleted);
    this.name = name;
    this.description = description;
  }

  /**
   * <p>Constructor without arguments.</p>
   */
  public SkillEntity() {
    super(null, false, false);
  }

  /**
   * <p>Create this entity from Skill Domain.</p>
   *
   * @param skill domain.
   * @return Skill Entity.
   */
  public static SkillEntity from(final Skill skill) {

    return new SkillEntity(
            skill.getId(),
            skill.isEnabled(),
            skill.isDeleted(),
            skill.getName(),
            skill.getDescription()
    );
  }

  /**
   * <p>Convert this entity to Skill Domain.</p>
   *
   * @return Permission.
   */
  public Skill toDomain() {

    return new Skill(
            UUID.randomUUID(),
            super.isEnabled(),
            super.isDeleted(),
            this.name,
            this.description
    );
  }
}
