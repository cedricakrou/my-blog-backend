package com.cedricakrou.my.blog.shared.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.Entity;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Entity representing a country.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
@Getter
public class Country extends Entity {
  private final String name;
  private final String isoCode;
  private final int indicative;

  /**
   * <p>Constructor.</p>
   *
   * @param id         Id.
   * @param enabled    Enabled
   * @param deleted    Deleted.
   * @param name       country Name.
   * @param isoCode    country isoCode.
   * @param indicative country indicative.
   */
  public Country(final UUID id,
                 final boolean enabled,
                 final boolean deleted,
                 final String name,
                 final String isoCode,
                 final int indicative
  ) {
    super(id, enabled, deleted);
    this.name = name;
    this.isoCode = isoCode;
    this.indicative = indicative;
  }
}
