package com.cedricakrou.my.blog.adapter.shared.primary.rest;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreatePermissionForm;
import com.cedricakrou.my.blog.shared.application.command.CreatePermissionCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreatePermissionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Permission Rest Controller.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@RestController
@RequestMapping("/permission")
public class PermissionRestController {

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade shared facade.
   */
  public PermissionRestController(
          final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>
   * Endpoint for permission creating.
   * </p>
   *
   * @param form form data.
   * @return ResponseEntity<Void> response.
   */
  @PostMapping(value = "")
  public ResponseEntity<Void> createPermission(
          final @RequestBody CreatePermissionForm form) {

    CreatePermissionCommand command =
            new CreatePermissionCommand(
                    form.getName(),
                    form.getDescription());

    CreatePermissionUseCase useCase = new CreatePermissionUseCase(sharedFacade);

    useCase.perform(command);

    return ResponseEntity.ok().build();
  }
}
