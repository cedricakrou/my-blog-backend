package com.cedricakrou.my.blog.adapter.shared.primary.rest;

import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>All rest endpoint of Country.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
@RestController
@RequestMapping("/country")
public final class CountryRestController {

  private final CountryRepository countryRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param countryRepository country repository.
   */
  private CountryRestController(final CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }
}
