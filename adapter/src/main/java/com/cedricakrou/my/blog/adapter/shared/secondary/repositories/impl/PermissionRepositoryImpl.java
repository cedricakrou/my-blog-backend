package com.cedricakrou.my.blog.adapter.shared.secondary.repositories.impl;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.PermissionEntity;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgPermissionRepository;
import com.cedricakrou.my.blog.shared.application.repository.PermissionRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Service
class PermissionRepositoryImpl implements PermissionRepository {

  private final PgPermissionRepository pgPermissionRepository;

  PermissionRepositoryImpl(
          final PgPermissionRepository pgPermissionRepository) {
    this.pgPermissionRepository = pgPermissionRepository;
  }


  @Override
  public void save(final Permission permission) {
    PermissionEntity entity = PermissionEntity.from(permission);

    this.pgPermissionRepository.save(entity);
  }

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

  @Override
  public void deleteAll() {
    this.pgPermissionRepository.deleteAll();
  }
}
