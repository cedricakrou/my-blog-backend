package com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.impl;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.RoleEntity;
import com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa.PgRoleRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * <p>A implementation of role repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@Service
public class RoleRepositoryImpl implements RoleRepository {

  private final PgRoleRepository pgRoleRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgRoleRepository Jpa Role Repository.
   */
  public RoleRepositoryImpl(final PgRoleRepository pgRoleRepository) {
    this.pgRoleRepository = pgRoleRepository;
  }

  /**
   * <p>Save the role.</p>
   *
   * @param role the new role.
   */
  @Transactional
  @Override
  public void save(final Role role) {

    RoleEntity roleEntity = RoleEntity.from(role);
    this.pgRoleRepository.save(roleEntity);
  }

  /**
   * <p>Find by name.</p>
   *
   * @param roleName role name.
   */
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

  /**
   * <p>Delete all.</p>
   */
  @Override
  public void deleteAll() {
    this.pgRoleRepository.deleteAll();
  }
}
