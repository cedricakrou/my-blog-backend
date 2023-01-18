package com.cedricakrou.my.blog.shared.application.usecase;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreateRoleCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.UUID;
import java.util.logging.Logger;
import lombok.SneakyThrows;

/**
 * <p>Use Case for the role creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public class CreateRoleUseCase implements UseCase<CreateRoleCommand> {

  private final Logger logger =
          Logger.getLogger(CreateRoleUseCase.class.getName());

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade Shared facade injecting;
   */
  public CreateRoleUseCase(final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>Perform method for the role creating.</p>
   *
   * @param command command of the use case.
   */
  @SneakyThrows
  @Override
  public void perform(final CreateRoleCommand command) {

    command.checkValidity();

    if (this.sharedFacade.findRoleByName(command.getName()).isPresent()) {
      throw new AlreadyExistsException("Role already exists with this name !");
    }

    Role role = new Role(
            UUID.randomUUID(),
            true,
            false,
            command.getName(),
            command.getDescription(),
            new Permission[]{});

    this.sharedFacade.addRole(role);

    this.logger.info("Role created !");
  }
}
