package com.cedricakrou.my.blog.user.domain.value.objects;

import com.cedricakrou.library.generic.aggregate.ValueObject;

/**
 * <p>Object value representing User Address.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
public class Address extends ValueObject {

  private final String nativeCountry;
  private final String liveCountry;
  private final String city;

  /**
   * <p>Default Constructor.</p>
   *
   * @param nativeCountry native country
   * @param liveCountry   live country
   * @param city          city
   * @param enabled       enabled
   * @param deleted       deleted
   */
  public Address(
          final String nativeCountry,
          final String liveCountry,
          final String city,
          final boolean enabled,
          final boolean deleted) {
    super(enabled, deleted);
    this.nativeCountry = nativeCountry;
    this.liveCountry = liveCountry;
    this.city = city;
  }
}
