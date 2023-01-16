package com.cedricakrou.my.blog.adapter.shared.primary.rest.form;

import lombok.Getter;

/**
 * <p>Dto for creating country.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
@Getter
public class CreateCountryForm {

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
  public CreateCountryForm(final String name,
                           final String isoCode,
                           final int indicative) {
    this.name = name;
    this.isoCode = isoCode;
    this.indicative = indicative;
  }
}
