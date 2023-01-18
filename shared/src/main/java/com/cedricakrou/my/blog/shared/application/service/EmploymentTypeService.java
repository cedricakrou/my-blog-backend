package com.cedricakrou.my.blog.shared.application.service;

import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
import java.util.Optional;

/**
 * <p>Service of Employment type.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
public interface EmploymentTypeService {
  /**
   * <p>Get employment type by name.</p>
   *
   * @param name name.
   * @return employment type or empty.
   */
  Optional<EmploymentType> findEmploymentTypeByName(String name);

  /**
   * <p>Save Employment Type.</p>
   *
   * @param type employment type.
   */
  void addEmploymentType(EmploymentType type);
}
