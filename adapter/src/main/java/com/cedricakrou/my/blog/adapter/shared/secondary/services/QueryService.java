package com.cedricakrou.my.blog.adapter.shared.secondary.services;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.CountryEntity;
import java.util.List;

/**
 * <p>To fetch data in the database.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
public interface QueryService {

  /**
   * <p>List of countries.</p>
   *
   * @return list of countries.
   */
  List<CountryEntity> findAllCountry();
}
