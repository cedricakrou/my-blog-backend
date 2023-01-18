package com.cedricakrou.my.blog.adapter.shared.primary.rest.form;

import lombok.Getter;

/**
 * <p>Dto for creating role.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Getter
public class CreateRoleForm {

  private final String name;
  private final String description;

  /**
   * <p>Default constructor.</p>
   *
   * @param name        name.
   * @param description description.
   */
  public CreateRoleForm(final String name, final String description) {
    this.name = name;
    this.description = description;
  }
}
