package com.cedricakrou.my.blog.shared.application.usecase;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreateCountryCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.UUID;
import java.util.logging.Logger;
import lombok.SneakyThrows;

/**
 * <p>Use Case of {@link Country} creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
public class CreateCountryUseCase implements UseCase<CreateCountryCommand> {

  private final Logger logger = Logger.getLogger(
          CreateCountryUseCase.class.getName()
  );

  private final SharedFacade sharedFacade;

  /**
   * <p>Default constructor.</p>
   *
   * @param sharedFacade Shared facade.
   */
  public CreateCountryUseCase(final SharedFacade sharedFacade) {
    this.sharedFacade = sharedFacade;
  }

  /**
   * <p>Main method.</p>
   *
   * @param command command of the use case.
   */
  @SneakyThrows
  @Override
  public void perform(final CreateCountryCommand command) {

    command.checkValidity();

    if (this.sharedFacade.findByCountryName(command.getName())
            .isPresent()) {
      throw new AlreadyExistsException(
              "Country Already exists with this name !"
      );
    }

    if (this.sharedFacade
            .findByCountryIsoCode(command.getIsoCode())
            .isPresent()) {
      throw new AlreadyExistsException(
              "Country Already exists with this iso code !"
      );
    }

    if (this.sharedFacade
            .findByCountryIndicative(command.getIndicative())
            .isPresent()) {
      throw new AlreadyExistsException(
              "Country Already exists with this indicative !"
      );
    }

    Country country = new Country(
            UUID.randomUUID(),
            true,
            false,
            command.getName(),
            command.getIsoCode(),
            command.getIndicative()
    );

    this.sharedFacade.saveCountry(country);

    this.logger.info("Country saved !");
  }
}
