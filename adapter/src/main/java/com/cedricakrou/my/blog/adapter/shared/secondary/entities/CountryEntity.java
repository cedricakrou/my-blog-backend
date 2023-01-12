package com.cedricakrou.my.blog.adapter.shared.secondary.entities;

import com.cedricakrou.library.generic.adapter.EntityRoot;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;

/**
 * <p>Entity Country.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
@Entity
@Table(name = "country")
@Getter
public class CountryEntity extends EntityRoot {

  @Column(name = "name", unique = true)
  private String name;
  @Column(name = "iso_code", unique = true)
  private String isoCode;
  @Column(name = "indicative", unique = true)
  private int indicative;

  /**
   * <p>Default constructor.</p>
   */
  public CountryEntity() {
    super(null, false, false);
  }

  /**
   * <p>Secondary constructor.</p>
   *
   * @param id         Identifier.
   * @param enabled    enabled.
   * @param deleted    deleted.
   * @param name       Name.
   * @param isoCode    iso code.
   * @param indicative indicative.
   */
  public CountryEntity(final UUID id,
                       final boolean enabled,
                       final boolean deleted,
                       final String name,
                       final String isoCode,
                       final int indicative) {
    super(id, enabled, deleted);
    this.name = name;
    this.isoCode = isoCode;
    this.indicative = indicative;
  }

  /**
   * <p>To convert Country Entity to Country.</p>
   *
   * @return country.
   */
  public Country toDomain() {
    return new Country(
            super.getId(),
            super.isEnabled(),
            super.isDeleted(),
            name,
            isoCode,
            indicative
    );
  }

  /**
   * <p>To create CountryEntity from Country.</p>
   *
   * @param country country.
   * @return country entity.
   */
  public static CountryEntity from(final Country country) {
    return new CountryEntity(
            country.getId(),
            country.isEnabled(),
            country.isDeleted(),
            country.getName(),
            country.getIsoCode(),
            country.getIndicative()
    );
  }
}
