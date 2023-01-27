package com.cedricakrou.my.blog.adapter.shared.primaries.rest;

import com.cedricakrou.my.blog.adapter.shared.primaries.rest.form.CreateSkillForm;
import com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm.SkillVm;
import com.cedricakrou.my.blog.adapter.shared.secondaries.services.query.SkillQueryService;
import com.cedricakrou.my.blog.shared.application.command.CreateSkillCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreateSkillUseCase;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  private final SkillQueryService skillQueryService;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade      shared facade.
   * @param skillQueryService skill query service
   */
  public SkillRestController(
          final SharedFacade sharedFacade,
          final SkillQueryService skillQueryService) {
    this.sharedFacade = sharedFacade;
    this.skillQueryService = skillQueryService;
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

  /**
   * <p>find all skills.</p>
   *
   * @return list of skills.
   */
  @GetMapping("")
  public ResponseEntity<List<SkillVm>> findAll() {

    return ResponseEntity.status(HttpStatus.OK)
            .body(
                    this.skillQueryService.findAll()
            );
  }
}
