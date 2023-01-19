package com.cedricakrou.my.blog.adapter.shared.primary.rest;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreateCountryForm;
import com.cedricakrou.my.blog.adapter.shared.primary.rest.vm.CountryVm;
import com.cedricakrou.my.blog.adapter.shared.secondary.services.query.CountryQueryService;
import com.cedricakrou.my.blog.shared.application.command.CreateCountryCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.usecase.CreateCountryUseCase;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  private final CountryQueryService countryQueryService;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade        country repository.
   * @param countryQueryService to fetch data in the database.
   */
  public CountryRestController(
          final SharedFacade sharedFacade,
          final CountryQueryService countryQueryService) {
    this.sharedFacade = sharedFacade;
    this.countryQueryService = countryQueryService;
  }

  /**
   * <p>Endpoint for country creating.</p>
   *
   * @param form Create country formula data.
   * @return Response.
   */
  @PostMapping("")
  public ResponseEntity<Void> create(
          final @RequestBody CreateCountryForm form) {

    CreateCountryCommand command = new CreateCountryCommand(
            form.getName(),
            form.getIsoCode(),
            form.getIndicative()
    );

    CreateCountryUseCase useCase = new CreateCountryUseCase(this.sharedFacade);

    useCase.perform(command);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
  }

  /**
   * <p>Endpoint for getting all countries.</p>
   *
   * @return list of countries.
   */
  @GetMapping("")
  public ResponseEntity<List<CountryVm>> getCountries() {

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                    this.countryQueryService.findAllCountries()
            );
  }
}

