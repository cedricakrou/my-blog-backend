package com.cedricakrou.my.blog.adapter.shared.primary.facade;

import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p>SharedFacade implementation.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
@Service
public final class SharedFacadeAdapter implements SharedFacade {

  private final CountryRepository countryRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param countryRepository country repository.
   */
  public SharedFacadeAdapter(final CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @Override
  public Optional<Country> findByCountryId(final UUID id) {

    return this.countryRepository.findById(id);
  }

  @Override
  public Optional<Country> findByCountryName(final String name) {

    return this.countryRepository.findByName(name);
  }

  @Override
  public Optional<Country> findByCountryIsoCode(final String isoCode) {

    return this.countryRepository.findByIsoCode(isoCode);
  }

  @Override
  public Optional<Country> findByCountryIndicative(final int indicative) {

    return this.countryRepository.findByIndicative(indicative);
  }

  @Override
  public void saveCountry(final Country country) {
    this.countryRepository.save(country);
  }
}
