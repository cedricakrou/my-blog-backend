package com.cedricakrou.my.blog.adapter.shared.secondary.services.query;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.vm.RoleVm;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgRoleRepository;
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
