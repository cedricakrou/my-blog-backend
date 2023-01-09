package com.cedricakrou.my.blog.shared.application.usecase;

import com.cedricakrou.library.generic.aggregate.application.UseCase;
import com.cedricakrou.my.blog.shared.application.command.CreateCountryCommand;
import com.cedricakrou.my.blog.shared.domain.entities.Country;

/**
 * <p>Use Case of {@link Country} creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
public class CreateCountryUseCase implements UseCase<CreateCountryCommand> {

  @Override
  public void perform(final CreateCountryCommand command) {
    // TODO: body of method.
  }
}
