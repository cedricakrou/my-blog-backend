package com.cedricakrou.my.blog.shared.application.repository;

import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.Optional;
import java.util.UUID;

/**
 * <p>Country repository interface.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
public interface CountryRepository {

  /**
   * <p>Get the country by his Id.</p>
   *
   * @param id Country identifier.
   * @return A country if it exits.
   */
  Optional<Country> findById(UUID id);

  /**
   * <p>Get the country by his Name.</p>
   *
   * @param name Country Name.
   * @return A country if it exits.
   */
  Optional<Country> findByName(String name);

  /**
   * <p>Get the country by his IsoCode.</p>
   *
   * @param isoCode Country Iso Code.
   * @return A country if it exits.
   */
  Optional<Country> findByIsoCode(String isoCode);

  /**
   * <p>Get the country by his Indicative.</p>
   *
   * @param indicative Country Indicative.
   * @return A country if it exits.
   */
  Optional<Country> findByIndicative(int indicative);

  /**
   * <p>Get the country.</p>
   *
   * @param country Country.
   */
  void save(Country country);

  /**
   * <p>Delete all countries.</p>
   */
  void deleteAll();
}
