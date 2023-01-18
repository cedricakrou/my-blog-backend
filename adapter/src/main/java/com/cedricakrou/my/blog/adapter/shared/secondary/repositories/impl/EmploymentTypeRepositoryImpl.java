package com.cedricakrou.my.blog.adapter.shared.secondary.repositories.impl;

import com.cedricakrou.my.blog.adapter.shared.secondary.entities.EmploymentTypeEntity;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgEmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.application.repository.EmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of Employment type.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Service
class EmploymentTypeRepositoryImpl implements EmploymentTypeRepository {

  private final PgEmploymentTypeRepository pgEmploymentTypeRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgEmploymentTypeRepository Jpa Employment type repository.
   */
   EmploymentTypeRepositoryImpl(
          final PgEmploymentTypeRepository pgEmploymentTypeRepository) {
    this.pgEmploymentTypeRepository = pgEmploymentTypeRepository;
  }

  @Override
  public void save(final EmploymentType employmentType) {

    EmploymentTypeEntity employmentTypeEntity =
            EmploymentTypeEntity.from(employmentType);
    this.pgEmploymentTypeRepository.save(employmentTypeEntity);
  }

  @Override
  public Optional<EmploymentType> findByName(final String name) {

    Optional<EmploymentTypeEntity> optionalEmploymentTypeEntity =
            this.pgEmploymentTypeRepository.findByName(name);

    if (optionalEmploymentTypeEntity.isPresent()) {
      EmploymentType employmentType =
              optionalEmploymentTypeEntity.get().toDomain();

      return Optional.of(employmentType);
    }

    return Optional.empty();
  }

  @Override
  public void deleteAll() {
    this.pgEmploymentTypeRepository.deleteAll();
  }
}
