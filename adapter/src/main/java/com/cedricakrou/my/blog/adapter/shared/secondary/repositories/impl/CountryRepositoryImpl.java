package com.cedricakrou.my.blog.adapter.shared.secondary.repositories.impl;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.CountryEntity;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgCountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p>Country repository implementation.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
@Service
public final class CountryRepositoryImpl implements CountryRepository {

  private final PgCountryRepository pgCountryRepository;

  /**
   * <p>Default constructor.
   *
   * @param pgCountryRepository Jpa country Repository.
   */
  public CountryRepositoryImpl(final PgCountryRepository pgCountryRepository) {
    this.pgCountryRepository = pgCountryRepository;
  }

  @Override
  public Optional<Country> findById(final UUID id) {

    Optional<CountryEntity> optionalCountry =
            this.pgCountryRepository.findById(id);

    return transformOptionCountryEntityToOptionalCountry(optionalCountry);
  }

  @Override
  public Optional<Country> findByName(final String name) {

    Optional<CountryEntity> optionalCountry =
            this.pgCountryRepository.findByName(name);

    return transformOptionCountryEntityToOptionalCountry(optionalCountry);
  }

  @Override
  public Optional<Country> findByIsoCode(final String isoCode) {
    Optional<CountryEntity> optionalCountry =
            this.pgCountryRepository.findByIsoCode(isoCode);

    return transformOptionCountryEntityToOptionalCountry(optionalCountry);
  }

  @Override
  public Optional<Country> findByIndicative(final int indicative) {

    Optional<CountryEntity> optionalCountry =
            this.pgCountryRepository.findByIndicative(indicative);

    return transformOptionCountryEntityToOptionalCountry(optionalCountry);
  }

  @Override
  public void save(final Country country) {
    CountryEntity countryEntity = CountryEntity.from(country);
    this.pgCountryRepository.save(countryEntity);
  }

  @Override
  public void deleteAll() {
    this.pgCountryRepository.deleteAll();
  }

  /**
   * <p>
   * From optionalCountryEntity To optionalCountry.
   * </p>
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
