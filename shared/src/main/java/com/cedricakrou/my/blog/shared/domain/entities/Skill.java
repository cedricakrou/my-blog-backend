package com.cedricakrou.my.blog.shared.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.DomainEntityRoot;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Entity representing a skill.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
@Getter
public class Skill extends DomainEntityRoot {

  private final String name;
  private final String description;

  /**
   * <p>Constructor.</p>
   *
   * @param id          Id.
   * @param enabled     Enabled
   * @param deleted     Deleted.
   * @param name        Skill name.
   * @param description Skill description.
   */
  public Skill(final UUID id,
               final boolean enabled,
               final boolean deleted,
               final String name,
               final String description
  ) {
    super(id, enabled, deleted);
    this.name = name;
    this.description = description;
  }
}
