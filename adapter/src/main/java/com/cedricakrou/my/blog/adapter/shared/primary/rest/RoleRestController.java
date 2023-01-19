package com.cedricakrou.my.blog.adapter.shared.primary.rest;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreateRoleForm;
import com.cedricakrou.my.blog.adapter.shared.primary.rest.vm.RoleVm;
import com.cedricakrou.my.blog.adapter.shared.secondary.services.query.RoleQueryService;
import com.cedricakrou.my.blog.shared.application.command.CreateRoleCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreateRoleUseCase;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Role Rest controller.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@RestController
@RequestMapping(value = "/role")
public class RoleRestController {

  private final SharedFacade sharedFacade;
  private final RoleQueryService roleQueryService;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade     shared facade.
   * @param roleQueryService role query service.
   */
  public RoleRestController(
          final SharedFacade sharedFacade,
          final RoleQueryService roleQueryService) {
    this.sharedFacade = sharedFacade;
    this.roleQueryService = roleQueryService;
  }

  /**
   * <p>
   * Endpoint for role creating.
   * </p>
   *
   * @param createRoleForm form data.
   * @return ResponseEntity<Void> response.
   */
  @PostMapping(value = "")
  public ResponseEntity<Void> createRole(
          final @RequestBody CreateRoleForm createRoleForm) {

    CreateRoleCommand command =
            new CreateRoleCommand(
                    createRoleForm.getName(),
                    createRoleForm.getDescription());

    CreateRoleUseCase useCase = new CreateRoleUseCase(sharedFacade);

    useCase.perform(command);

    return ResponseEntity.ok().build();
  }

  /**
   * <p>
   * Endpoint for getting all roles.
   * </p>
   *
   * @return ResponseEntity<List < RoleVm> list of roles.
   */
  @GetMapping("")
  public ResponseEntity<List<RoleVm>> findAll() {

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.roleQueryService.findAll());
  }
}
