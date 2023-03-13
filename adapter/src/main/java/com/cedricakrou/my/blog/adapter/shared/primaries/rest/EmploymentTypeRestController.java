package com.cedricakrou.my.blog.adapter.shared.primaries.rest;

import com.cedricakrou.my.blog.adapter.shared.primaries.rest.form.CreateEmploymentTypeForm;
import com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm.EmploymentTypeVm;
import com.cedricakrou.my.blog.adapter.shared.secondaries.services.query.EmploymentTypeQueryService;
import com.cedricakrou.my.blog.shared.application.command.CreateEmploymentTypeCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreateEmploymentTypeUseCase;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  private final EmploymentTypeQueryService employmentTypeQueryService;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade               SharedFacade.
   * @param employmentTypeQueryService employment type query service.
   */
  public EmploymentTypeRestController(
          final SharedFacade sharedFacade,
          final EmploymentTypeQueryService employmentTypeQueryService) {
    this.sharedFacade = sharedFacade;
    this.employmentTypeQueryService = employmentTypeQueryService;
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

  /**
   * <p>Get list of employment type.</p>
   *
   * @return response.
   */
  @GetMapping("")
  public ResponseEntity<List<EmploymentTypeVm>> findAll() {

    return ResponseEntity.status(HttpStatus.OK).body(
            this.employmentTypeQueryService.findAll()
    );
  }
}
