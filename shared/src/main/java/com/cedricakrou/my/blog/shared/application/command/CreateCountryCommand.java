package com.cedricakrou.my.blog.shared.application.command;

import com.cedricakrou.library.generic.aggregate.application.Command;
import lombok.Getter;

/**
 * <p>Command for the Use case CreateCountryUseCase creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
@Getter
public class CreateCountryCommand implements Command {

  private final String name;
  private final String isoCode;
  private final int indicative;

  /**
   * <p>Default constructor.</p>
   *
   * @param name       Name of country.
   * @param isoCode    Iso code of country.
   * @param indicative indicative of country.
   */
  public CreateCountryCommand(final String name,
                              final String isoCode,
                              final int indicative) {
    this.name = name;
    this.isoCode = isoCode;
    this.indicative = indicative;
  }
}
