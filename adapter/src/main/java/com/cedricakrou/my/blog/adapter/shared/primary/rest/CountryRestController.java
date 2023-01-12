package com.cedricakrou.my.blog.adapter.shared.primary.rest;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreateCountryForm;
import com.cedricakrou.my.blog.shared.application.command.CreateCountryCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreateCountryUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>All rest endpoint of Country.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
@RestController
@RequestMapping("/country")
public final class CountryRestController {

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade country repository.
   */
  public CountryRestController(
          final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>Endpoint for country creating.</p>
   *
   * @param form Create country formula data.
   */
  @PostMapping("")
  public void create(final @RequestBody CreateCountryForm form) {

    CreateCountryCommand command = new CreateCountryCommand(
            form.getName(),
            form.getIsoCode(),
            form.getIndicative()
    );

    CreateCountryUseCase useCase = new CreateCountryUseCase(this.sharedFacade);

    useCase.perform(command);
  }

}
