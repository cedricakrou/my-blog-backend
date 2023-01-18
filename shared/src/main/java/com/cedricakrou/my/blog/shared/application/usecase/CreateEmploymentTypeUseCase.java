package com.cedricakrou.my.blog.shared.application.usecase;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreateEmploymentTypeCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
import java.util.UUID;
import java.util.logging.Logger;
import lombok.SneakyThrows;

/**
 * <p>Use Case for the permission creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public class CreateEmploymentTypeUseCase implements
        UseCase<CreateEmploymentTypeCommand> {

  private final Logger logger =
          Logger.getLogger(CreateEmploymentTypeUseCase.class.getName());

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade Shared facade injecting;
   */
  public CreateEmploymentTypeUseCase(final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>Perform method for the permission creating.</p>
   *
   * @param command command of the use case.
   */
  @SneakyThrows
  @Override
  public void perform(final CreateEmploymentTypeCommand command) {

    command.checkValidity();

    if (this.sharedFacade.findEmploymentTypeByName(command.getName())
            .isPresent()) {
      throw new AlreadyExistsException(
              "Employment type already exists with this name !"
      );
    }

    EmploymentType permissions = new EmploymentType(
            UUID.randomUUID(),
            true,
            false,
            command.getName(),
            command.getDescription());

    this.sharedFacade.addEmploymentType(permissions);

    this.logger.info("Employment type created !");
  }
}
