package com.cedricakrou.my.blog.adapter.user.primaries.rest;

import com.cedricakrou.my.blog.adapter.user.primaries.rest.form.CreateUserForm;
import com.cedricakrou.my.blog.user.application.commands.CreateUserCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.usecases.CreateUserUseCase;
import com.cedricakrou.my.blog.user.domain.event.CreateUserEvent;
import org.springframework.http.HttpStatus;
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
  private final CreateUserEvent createUserEvent;

  /**
   * <p>Default constructor.</p>
   *
   * @param userFacade user facade.
   * @param createUserEvent create user event.
   */
  UserRestController(final UserFacade userFacade,
                     final CreateUserEvent createUserEvent) {
    this.userFacade = userFacade;
    this.createUserEvent = createUserEvent;
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
            this.userFacade,
            createUserEvent
    );

    useCase.perform(command);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
  }
}
