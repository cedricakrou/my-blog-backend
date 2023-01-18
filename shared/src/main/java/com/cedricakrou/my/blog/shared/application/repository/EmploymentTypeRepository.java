package com.cedricakrou.my.blog.shared.application.repository;

import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
import java.util.Optional;

/**
 * <p>Employment Type repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
public interface EmploymentTypeRepository {

  /**
   * <p>Save a new employment type.</p>
   *
   * @param employmentType the new employment type.
   */
  void save(EmploymentType employmentType);

  /**
   * <p>find a employment type by name.</p>
   *
   * @param name the name.
   * @return the employment type if it found.
   */
  Optional<EmploymentType> findByName(String name);

  /**
   * <p>Delete all employment type.</p>
   */
  void deleteAll();
}
