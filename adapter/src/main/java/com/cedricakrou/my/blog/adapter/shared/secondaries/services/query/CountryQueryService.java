package com.cedricakrou.my.blog.adapter.shared.secondaries.services.query;

import com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm.CountryVm;
import java.util.List;

/**
 * <p>To fetch data in the database.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
public interface CountryQueryService {

  /**
   * <p>List of countries.</p>
   *
   * @return list of countries.
   */
  List<CountryVm> findAllCountries();
}
