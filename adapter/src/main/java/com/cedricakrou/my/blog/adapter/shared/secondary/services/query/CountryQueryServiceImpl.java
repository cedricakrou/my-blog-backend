package com.cedricakrou.my.blog.adapter.shared.secondary.services.query;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.vm.CountryVm;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgCountryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of QueryService.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
@Service
public class CountryQueryServiceImpl implements CountryQueryService {

  private final PgCountryRepository pgCountryRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgCountryRepository Jpa Country repository.
   */
  public CountryQueryServiceImpl(
          final PgCountryRepository pgCountryRepository) {
    this.pgCountryRepository = pgCountryRepository;
  }

  /**
   * <p>List of countries.</p>
   *
   * @return list of countries.
   */
  @Override
  public List<CountryVm> findAllCountries() {
    return this.pgCountryRepository.findAll()
            .stream()
            .filter(it -> !it.isDeleted())
            .map(CountryVm::new)
            .collect(Collectors.toList());
  }
}
