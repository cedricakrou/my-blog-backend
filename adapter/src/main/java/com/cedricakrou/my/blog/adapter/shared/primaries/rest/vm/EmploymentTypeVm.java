package com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.EmploymentTypeEntity;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Employment type Vm.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
@Getter
public class EmploymentTypeVm {

  private final UUID id;
  private final String name;
  private final String description;

  /**
   * <p>Default constructor.</p>
   *
   * @param employmentTypeEntity employment type entity.
   */
  public EmploymentTypeVm(final EmploymentTypeEntity employmentTypeEntity) {
    this.id = employmentTypeEntity.getId();
    this.name = employmentTypeEntity.getName();
    this.description = employmentTypeEntity.getDescription();
  }
}
