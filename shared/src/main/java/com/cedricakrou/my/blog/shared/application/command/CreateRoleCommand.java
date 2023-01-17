package com.cedricakrou.my.blog.shared.application.command;

import com.cedricakrou.library.generic.aggregate.application.Command;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;

/**
 * <p>
 * Command for the Use Case Create Role Command.
 * </p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Getter
public class CreateRoleCommand implements Command {

  @NotEmpty(message = "Role name is mandatory !")
  private final String name;
  private final String description;

  /**
   * <p>Default constructor.</p>
   *
   * @param name        role name.
   * @param description description name.
   */
  public CreateRoleCommand(
          String name,
          String description
  ) {
    this.name = name;
    this.description = description;
  }
}
