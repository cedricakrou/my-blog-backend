package com.cedricakrou.my.blog.adapter.shared.secondary.repositories.impl;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.RoleEntity;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgRoleRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * <p>A implementation of role repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Service
public final class RoleRepositoryImpl implements RoleRepository {

  private final PgRoleRepository pgRoleRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgRoleRepository Jpa Role Repository.
   */
  public RoleRepositoryImpl(final PgRoleRepository pgRoleRepository) {
    this.pgRoleRepository = pgRoleRepository;
  }

  @Override
  public void save(final Role role) {

    RoleEntity roleEntity = RoleEntity.from(role);
    this.pgRoleRepository.save(roleEntity);
  }

  @Override
  public Optional<Role> findByName(final String roleName) {

    Optional<RoleEntity> optionalRoleEntity =
            this.pgRoleRepository.findByName(roleName);

    if (optionalRoleEntity.isPresent()) {

      Role role = optionalRoleEntity.get().toDomain();

      return Optional.of(role);
    }

    return Optional.empty();
  }

  @Override
  public void deleteAll() {
    this.pgRoleRepository.deleteAll();
  }
}
