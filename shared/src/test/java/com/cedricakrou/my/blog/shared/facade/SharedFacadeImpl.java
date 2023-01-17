package com.cedricakrou.my.blog.shared.facade;

import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.Optional;
import java.util.UUID;

/**
 * <p>
 * Implementation of
 * {@link com.cedricakrou.my.blog.shared.application.facade.SharedFacade}.
 * </p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
public class SharedFacadeImpl implements SharedFacade {

  CountryRepository countryRepository;
  RoleRepository roleRepository;

  public SharedFacadeImpl(CountryRepository countryRepository,
                          RoleRepository roleRepository) {
    this.countryRepository = countryRepository;
    this.roleRepository = roleRepository;
  }

  @Override
  public Optional<Country> findByCountryId(UUID id) {
    return this.countryRepository.findById(id);
  }

  @Override
  public Optional<Country> findByCountryName(String name) {
    return this.countryRepository.findByName(name);
  }

  @Override
  public Optional<Country> findByCountryIsoCode(String isoCode) {
    return this.countryRepository.findByIsoCode(isoCode);
  }

  @Override
  public Optional<Country> findByCountryIndicative(int indicative) {
    return this.countryRepository.findByIndicative(indicative);
  }

  @Override
  public void saveCountry(Country country) {
    this.countryRepository.save(country);
  }
}
