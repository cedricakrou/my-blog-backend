package com.cedricakrou.my.blog.adapter.shared.secondary.services.query;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.vm.EmploymentTypeVm;
import java.util.List;

/**
 * <p>Service for querying employment type in the database.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
public interface EmploymentTypeQueryService {

  /**
   * <p>Get all employment type.</p>
   *
   * @return list of employment types.
   */
  List<EmploymentTypeVm> findAll();
}
