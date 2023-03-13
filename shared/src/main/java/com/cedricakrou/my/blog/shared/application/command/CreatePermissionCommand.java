package com.cedricakrou.my.blog.shared.application.command;

import com.cedricakrou.library.generic.aggregate.application.Command;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;

/**
 * <p>
 * Command for the Use Case Create Permission Command.
 * </p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Getter
public class CreatePermissionCommand implements Command {

  @NotEmpty(message = "Permission name is mandatory !")
  private final String name;
  private final String description;

  /**
   * <p>Default constructor.</p>
   *
   * @param name        permission name.
   * @param description description name.
   */
  public CreatePermissionCommand(
          final String name,
          final String description
  ) {
    this.name = name;
    this.description = description;
  }
}
