package com.cedricakrou.my.blog.adapter.shared.secondaries.services.query;

import com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm.RoleVm;
import java.util.List;

/**
 * <p>Query for getting role in database.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
public interface RoleQueryService {
  /**
   * <p>Get all roles in database.</p>
   *
   * @return List of all roles.
   */
  List<RoleVm> findAll();
}
