package com.cedricakrou.my.blog.adapter.shared.secondaries.services.query.impl;

import com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm.RoleVm;
import com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa.PgRoleRepository;
import com.cedricakrou.my.blog.adapter.shared.secondaries.services.query.RoleQueryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of RoleService.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
@Service
class RoleQueryServiceImpl implements RoleQueryService {

  private final PgRoleRepository pgRoleRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgRoleRepository role repository.
   */
  RoleQueryServiceImpl(final PgRoleRepository pgRoleRepository) {
    this.pgRoleRepository = pgRoleRepository;
  }

  @Override
  public List<RoleVm> findAll() {
    return this.pgRoleRepository.findAll()
            .stream()
            .filter(it -> !it.isDeleted())
            .map(RoleVm::new)
            .collect(Collectors.toList());
  }
}
