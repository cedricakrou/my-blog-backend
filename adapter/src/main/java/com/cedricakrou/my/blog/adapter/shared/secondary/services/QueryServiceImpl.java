package com.cedricakrou.my.blog.adapter.shared.secondary.services;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.CountryEntity;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgCountryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of QueryService.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
@Service
public class QueryServiceImpl implements QueryService {

  private final PgCountryRepository pgCountryRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgCountryRepository Jpa Country repository.
   */
  public QueryServiceImpl(final PgCountryRepository pgCountryRepository) {
    this.pgCountryRepository = pgCountryRepository;
  }

  /**
   * <p>List of countries.</p>
   *
   * @return list of countries.
   */
  @Override
  public List<CountryEntity> findAllCountry() {
    return this.pgCountryRepository.findAll();
  }
}
