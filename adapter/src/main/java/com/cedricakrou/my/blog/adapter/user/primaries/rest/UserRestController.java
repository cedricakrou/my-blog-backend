package com.cedricakrou.my.blog.adapter.user.primaries.rest;

import com.cedricakrou.my.blog.adapter.user.primaries.rest.form.CreateUserForm;
import com.cedricakrou.my.blog.user.application.commands.CreateUserCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.usecases.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KAKOU Akrou Cedric 2023-01-24
 */
@RestController
@RequestMapping("/user")
class UserRestController {

  private final UserFacade userFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param userFacade user facade.
   */
  UserRestController(final UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  /**
   * <p>Api for creating a new user.</p>
   *
   * @param form form.
   * @return response.
   */
  @PostMapping("")
  public ResponseEntity<Void> createUser(
          final @RequestBody CreateUserForm form) {

    CreateUserCommand command = new CreateUserCommand(
            form.getEmail(),
            form.getUsername()
    );

    CreateUserUseCase useCase = new CreateUserUseCase(
            this.userFacade
    );

    useCase.perform(command);

    return ResponseEntity
            .ok()
            .build();
  }
}
