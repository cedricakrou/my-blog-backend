package com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.CountryEntity;
import lombok.Getter;

/**
 * <p>View Model of country.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
@Getter
public class CountryVm {

  private final String name;
  private final String isoCode;
  private final int indicative;

  /**
   * <p>Default constructor.</p>
   *
   * @param countryEntity country entity.
   */
  public CountryVm(final CountryEntity countryEntity) {
    this.name = countryEntity.getName();
    this.isoCode = countryEntity.getIsoCode();
    this.indicative = countryEntity.getIndicative();
  }
}
