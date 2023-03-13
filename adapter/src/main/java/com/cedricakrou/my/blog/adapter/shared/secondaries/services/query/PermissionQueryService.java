package com.cedricakrou.my.blog.adapter.shared.secondaries.services.query;

import com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm.PermissionVm;
import java.util.List;

/**
 * <p>Service for getting Permission.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
public interface PermissionQueryService {

  /**
   * <p>Get all permissions.</p>
   *
   * @return list of permissions.
   */
  List<PermissionVm> findAll();
}
