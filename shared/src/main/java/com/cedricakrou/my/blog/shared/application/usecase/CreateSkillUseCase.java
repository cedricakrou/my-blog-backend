package com.cedricakrou.my.blog.shared.application.usecase;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreateSkillCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.domain.entities.Skill;
import java.util.UUID;
import java.util.logging.Logger;
import lombok.SneakyThrows;

/**
 * <p>Use Case for the skill creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public class CreateSkillUseCase implements UseCase<CreateSkillCommand> {

  private final Logger logger =
          Logger.getLogger(CreateSkillUseCase.class.getName());

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade Shared facade injecting;
   */
  public CreateSkillUseCase(final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>Perform method for the role creating.</p>
   *
   * @param command command of the use case.
   */
  @SneakyThrows
  @Override
  public void perform(final CreateSkillCommand command) {

    command.checkValidity();

    if (this.sharedFacade.findSkillByName(command.getName()).isPresent()) {
      throw new AlreadyExistsException("Skill already exists with this name !");
    }

    Skill skill = new Skill(
            UUID.randomUUID(),
            true,
            false,
            command.getName(),
            command.getDescription());

    this.sharedFacade.addSkill(skill);

    this.logger.info("Skill created !");
  }
}
