package com.cedricakrou.my.blog.shared.application.usecase;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.my.blog.shared.application.command.CreateRoleCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;

/**
 * <p>Use Case for the role creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public class CreateRoleUseCase implements UseCase<CreateRoleCommand> {

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
  @Override
  public void perform(CreateRoleCommand command) {

    command.checkValidity();
  }
}
