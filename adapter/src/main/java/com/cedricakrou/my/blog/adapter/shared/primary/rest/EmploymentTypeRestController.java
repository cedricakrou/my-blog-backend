package com.cedricakrou.my.blog.adapter.shared.primary.rest;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreateEmploymentTypeForm;
import com.cedricakrou.my.blog.shared.application.command.CreateEmploymentTypeCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreateEmploymentTypeUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Employment type APIs.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@RestController
@RequestMapping(value = "/employment-type")
public class EmploymentTypeRestController {

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade SharedFacade.
   */
  public EmploymentTypeRestController(
          final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>
   * Endpoint for employment type creating.
   * </p>
   *
   * @param form form data.
   * @return ResponseEntity<Void> response.
   */
  @PostMapping(value = "")
  public ResponseEntity<Void> createRole(
          final @RequestBody CreateEmploymentTypeForm form) {

    CreateEmploymentTypeCommand command =
            new CreateEmploymentTypeCommand(
                    form.getName(),
                    form.getDescription());

    CreateEmploymentTypeUseCase useCase =
            new CreateEmploymentTypeUseCase(this.sharedFacade);

    useCase.perform(command);

    return ResponseEntity.ok().build();
  }
}
