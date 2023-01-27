package com.cedricakrou.my.blog.adapter.shared.secondaries.services.query.impl;

import com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm.PermissionVm;
import com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa.PgPermissionRepository;
import com.cedricakrou.my.blog.adapter.shared.secondaries.services.query.PermissionQueryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p>Service for querying role in database.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
@Service
class PermissionQueryServiceImpl implements PermissionQueryService {

  private final PgPermissionRepository permissionRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param permissionRepository permission repository.
   */
  PermissionQueryServiceImpl(
          final PgPermissionRepository permissionRepository) {
    this.permissionRepository = permissionRepository;
  }

  /**
   * <p>Get all roles.</p>
   *
   * @return list of all roles.
   */
  @Override
  public List<PermissionVm> findAll() {

    return this.permissionRepository.findAll()
            .stream()
            .filter(it -> !it.isDeleted())
            .map(PermissionVm::new)
            .collect(Collectors.toList());
  }
}
