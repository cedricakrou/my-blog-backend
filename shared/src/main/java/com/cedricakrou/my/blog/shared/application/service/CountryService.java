package com.cedricakrou.my.blog.shared.application.service;

import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.Optional;
import java.util.UUID;

/**
 * <p>Repository's CountryRepository Service.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
public interface CountryService {

  /**
   * <p>Get the country by his Id.</p>
   *
   * @param id Country identifier.
   * @return A country if it exits.
   */
  Optional<Country> findByCountryId(UUID id);

  /**
   * <p>Get the country by his Name.</p>
   *
   * @param name Country Name.
   * @return A country if it exits.
   */
  Optional<Country> findByCountryName(String name);

  /**
   * <p>Get the country by his IsoCode.</p>
   *
   * @param isoCode Country Iso Code.
   * @return A country if it exits.
   */
  Optional<Country> findByCountryIsoCode(String isoCode);

  /**
   * <p>Get the country by his Indicative.</p>
   *
   * @param indicative Country Indicative.
   * @return A country if it exits.
   */
  Optional<Country> findByCountryIndicative(int indicative);

  /**
   * <p>Save the country.</p>
   *
   * @param country Country.
   */
  void saveCountry(Country country);
}
