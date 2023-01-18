package com.cedricakrou.my.blog.adapter.shared.primary.rest;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreateRoleForm;
import com.cedricakrou.my.blog.shared.application.command.CreateRoleCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreateRoleUseCase;
import org.springframework.http.ResponseEntity;
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

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade shared facade.
   */
  public RoleRestController(
          final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
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
}
