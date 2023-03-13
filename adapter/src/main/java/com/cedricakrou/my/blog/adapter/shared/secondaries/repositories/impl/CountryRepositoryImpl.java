package com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.impl;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.CountryEntity;
import com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa.PgCountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * <p>Country repository implementation.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
@Service
public class CountryRepositoryImpl implements CountryRepository {

  private final PgCountryRepository pgCountryRepository;

  /**
   * <p>Default constructor.
   *
   * @param pgCountryRepository Jpa country Repository.
   */
  public CountryRepositoryImpl(final PgCountryRepository pgCountryRepository) {
    this.pgCountryRepository = pgCountryRepository;
  }

  /**
   * <p>Find Country By Id.</p>
   *
   * @param id Country identifier.
   * @return country or empty.
   */
  @Override
  public Optional<Country> findById(final UUID id) {

    Optional<CountryEntity> optionalCountry =
            this.pgCountryRepository.findById(id);

    return transformOptionCountryEntityToOptionalCountry(optionalCountry);
  }

  /**
   * <p>Find Country By Name.</p>
   *
   * @param name Country name.
   * @return country or empty.
   */
  @Override
  public Optional<Country> findByName(final String name) {

    Optional<CountryEntity> optionalCountry =
            this.pgCountryRepository.findByName(name);

    return transformOptionCountryEntityToOptionalCountry(optionalCountry);
  }

  /**
   * <p>Find By Iso Code.</p>
   *
   * @param isoCode Country iso code.
   * @return country or empty.
   */
  @Override
  public Optional<Country> findByIsoCode(final String isoCode) {
    Optional<CountryEntity> optionalCountry =
            this.pgCountryRepository.findByIsoCode(isoCode);

    return transformOptionCountryEntityToOptionalCountry(optionalCountry);
  }

  /**
   * <p>Find By Indicative.</p>
   *
   * @param indicative Country indicative.
   * @return country or empty.
   */
  @Override
  public Optional<Country> findByIndicative(final int indicative) {

    Optional<CountryEntity> optionalCountry =
            this.pgCountryRepository.findByIndicative(indicative);

    return transformOptionCountryEntityToOptionalCountry(optionalCountry);
  }

  /**
   * <p>Save country.</p>
   *
   * @param country Country.
   */
  @Transactional
  @Override
  public void save(final Country country) {
    CountryEntity countryEntity = CountryEntity.from(country);
    this.pgCountryRepository.save(countryEntity);
  }

  /**
   * <p>Delete all countries.</p>
   */
  @Override
  public void deleteAll() {
    this.pgCountryRepository.deleteAll();
  }

  /**
   * <p>From optionalCountryEntity To optionalCountry.</p>
   *
   * @param optionalCountry optional country.
   * @return Option Country.
   */
  private Optional<Country> transformOptionCountryEntityToOptionalCountry(
          final Optional<CountryEntity> optionalCountry) {

    if (optionalCountry.isPresent()) {
      Country country = optionalCountry.get().toDomain();
      return Optional.of(country);
    }

    return Optional.empty();
  }
}
