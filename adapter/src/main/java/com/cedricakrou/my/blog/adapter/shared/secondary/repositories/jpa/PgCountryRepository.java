package com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.CountryEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Repository of {@link  CountryEntity}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
@Repository
public interface PgCountryRepository extends
        JpaRepository<CountryEntity, UUID> {

  /**
   * <p>Search a country by name.</p>
   *
   * @param name name.
   * @return country if it exists.
   */
  Optional<CountryEntity> findByName(String name);

  /**
   * <p>Search a country by isoCode.</p>
   *
   * @param isoCode iso code.
   * @return country if it exists.
   */
  Optional<CountryEntity> findByIsoCode(String isoCode);

  /**
   * <p>Search a country by indicative.</p>
   *
   * @param indicative indicative.
   * @return country if it exists.
   */
  Optional<CountryEntity> findByIndicative(int indicative);
}
