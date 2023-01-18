package com.cedricakrou.my.blog.shared.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.Entity;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Entity representing a type of employment.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
@Getter
public class EmploymentType extends Entity {

  private String name;
  private String description;

  /**
   * <p>Constructor.</p>
   *
   * @param id          Id.
   * @param enabled     Enabled
   * @param deleted     Deleted.
   * @param name        Employment type name.
   * @param description Employment Type description.
   */
  public EmploymentType(final UUID id,
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
