package com.cedricakrou.my.blog.adapter.shared.secondary.entities;

import com.cedricakrou.library.generic.adapter.EntityRoot;
import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;

/**
 * <p>Entity Role.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Entity
@Table(name = "employment_type")
@Getter
public class EmploymentTypeEntity extends EntityRoot {

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
  protected EmploymentTypeEntity(final UUID id,
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
  public EmploymentTypeEntity() {
    super(null, false, false);
  }

  /**
   * <p>Create this entity from Employment Type Domain.</p>
   *
   * @param employmentType domain.
   * @return Permission Entity.
   */
  public static EmploymentTypeEntity from(final EmploymentType employmentType) {

    return new EmploymentTypeEntity(
            employmentType.getId(),
            employmentType.isEnabled(),
            employmentType.isDeleted(),
            employmentType.getName(),
            employmentType.getDescription()
    );
  }

  /**
   * <p>Convert this entity to Employment Type Domain.</p>
   *
   * @return Employment Type.
   */
  public EmploymentType toDomain() {

    return new EmploymentType(
            UUID.randomUUID(),
            super.isEnabled(),
            super.isDeleted(),
            this.name,
            this.description
    );
  }
}
