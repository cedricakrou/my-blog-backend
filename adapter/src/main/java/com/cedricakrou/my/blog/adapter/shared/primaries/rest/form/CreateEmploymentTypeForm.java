package com.cedricakrou.my.blog.adapter.shared.primaries.rest.form;

import lombok.Getter;

/**
 * <p>Dto for creating employment type.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Getter
public class CreateEmploymentTypeForm {

  private final String name;
  private final String description;

  /**
   * <p>Default constructor.</p>
   *
   * @param name        name.
   * @param description description.
   */
  public CreateEmploymentTypeForm(final String name, final String description) {
    this.name = name;
    this.description = description;
  }
}
