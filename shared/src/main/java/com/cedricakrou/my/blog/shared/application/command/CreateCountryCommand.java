package com.cedricakrou.my.blog.shared.application.command;

import com.cedricakrou.library.generic.aggregate.application.Command;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

/**
 * <p>Command for the Use case CreateCountryUseCase creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
@Getter
public class CreateCountryCommand implements Command {

  @NotEmpty(message = "Country name is mandatory !")
  private final String name;
  @SuppressWarnings("MagicNumber")
  @NotEmpty(message = "Country Iso Code is mandatory !")
  @Size(message = "Country iso must be 3 characters !", min = 3, max = 3)
  private final String isoCode;
  @NotNull(message = "Country Indicative is mandatory !")
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
