package com.cedricakrou.my.blog.adapter.shared.primary.rest;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreateSkillForm;
import com.cedricakrou.my.blog.shared.application.command.CreateSkillCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreateSkillUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Skill Rest Controller.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@RestController
@RequestMapping("/skill")
public class SkillRestController {

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade shared facade.
   */
  public SkillRestController(
          final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>
   * Endpoint for skill creating.
   * </p>
   *
   * @param form form data.
   * @return ResponseEntity<Void> response.
   */
  @PostMapping(value = "")
  public ResponseEntity<Void> createSkill(
          final @RequestBody CreateSkillForm form) {

    CreateSkillCommand command =
            new CreateSkillCommand(
                    form.getName(),
                    form.getDescription());

    CreateSkillUseCase useCase = new CreateSkillUseCase(sharedFacade);

    useCase.perform(command);

    return ResponseEntity.ok().build();
  }
}
