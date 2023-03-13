package com.cedricakrou.my.blog.shared.application.usecase;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreatePermissionCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.UUID;
import java.util.logging.Logger;
import lombok.SneakyThrows;

/**
 * <p>Use Case for the permission creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public class CreatePermissionUseCase implements
        UseCase<CreatePermissionCommand> {

  private final Logger logger =
          Logger.getLogger(CreatePermissionUseCase.class.getName());

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade Shared facade injecting;
   */
  public CreatePermissionUseCase(final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>Perform method for the permission creating.</p>
   *
   * @param command command of the use case.
   */
  @SneakyThrows
  @Override
  public void perform(final CreatePermissionCommand command) {

    command.checkValidity();

    if (this.sharedFacade.findPermissionByName(command.getName())
            .isPresent()) {
      throw new AlreadyExistsException(
              "Permission already exists with this name !"
      );
    }

    Permission permissions = new Permission(
            UUID.randomUUID(),
            true,
            false,
            command.getName(),
            command.getDescription(),
            new Role[]{});

    this.sharedFacade.addPermission(permissions);

    this.logger.info("Permission created !");
  }
}
