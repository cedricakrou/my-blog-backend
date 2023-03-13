package com.cedricakrou.my.blog.adapter.user.primaries.rest;

import com.cedricakrou.my.blog.adapter.user.primaries.rest.form.LoginDtoRequest;
import com.cedricakrou.my.blog.user.application.commands.LoginCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.usecases.LoginUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KAKOU Akrou Cedric 2023-03-13
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationRestController {

  private final UserFacade userFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param userFacade user facade.
   */
  public AuthenticationRestController(
          final UserFacade userFacade
  ) {
    this.userFacade = userFacade;
  }

  /**
   * <p>Api for user logging.</p>
   *
   * @param form form.
   * @return response.
   */
  @PostMapping("")
  public ResponseEntity<String> login(
          final @RequestBody LoginDtoRequest form) {

    LoginCommand command = new LoginCommand(
            form.getUsername(),
            form.getPassword()
    );

    LoginUseCase useCase = new LoginUseCase(
            this.userFacade
    );

    String token = useCase.perform(command);

    return new ResponseEntity<>(token, HttpStatus.OK);
  }
}
