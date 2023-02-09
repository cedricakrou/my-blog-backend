package com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.impl;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.PermissionEntity;
import com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa.PgPermissionRepository;
import com.cedricakrou.my.blog.shared.application.repository.PermissionRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of {@link PermissionRepository}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Service
public class PermissionRepositoryImpl implements PermissionRepository {

  private final PgPermissionRepository pgPermissionRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgPermissionRepository permission repository.
   */
  public PermissionRepositoryImpl(
          final PgPermissionRepository pgPermissionRepository) {
    this.pgPermissionRepository = pgPermissionRepository;
  }

  /**
   * <p>save permission.</p>
   *
   * @param permission the new permission.
   */
  @Transactional
  @Override
  public void save(final Permission permission) {
    PermissionEntity entity = PermissionEntity.from(permission);

    this.pgPermissionRepository.save(entity);
  }

  /**
   * <p>find permission by name.</p>
   *
   * @param name the permission name.
   * @return permission or empty.
   */
  @Override
  public Optional<Permission> findByName(final String name) {

    Optional<PermissionEntity> optionalPermissionEntity =
            this.pgPermissionRepository.findByName(name);

    if (optionalPermissionEntity.isPresent()) {
      Permission permission = optionalPermissionEntity.get().toDomain();

      return Optional.of(permission);
    }

    return Optional.empty();
  }

  /**
   * <p>delete all permissions.</p>
   */
  @Override
  public void deleteAll() {
    this.pgPermissionRepository.deleteAll();
  }
}
