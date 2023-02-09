package com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.impl;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.EmploymentTypeEntity;
import com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa.PgEmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.application.repository.EmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of Employment type.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Service
public class EmploymentTypeRepositoryImpl implements EmploymentTypeRepository {

  private final PgEmploymentTypeRepository pgEmploymentTypeRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgEmploymentTypeRepository Jpa Employment type repository.
   */
  public EmploymentTypeRepositoryImpl(
          final PgEmploymentTypeRepository pgEmploymentTypeRepository) {
    this.pgEmploymentTypeRepository = pgEmploymentTypeRepository;
  }

  /**
   * <p>Save employment type.</p>
   *
   * @param employmentType the new employment type.
   */
  @Override
  public void save(final EmploymentType employmentType) {

    EmploymentTypeEntity employmentTypeEntity =
            EmploymentTypeEntity.from(employmentType);
    this.pgEmploymentTypeRepository.save(employmentTypeEntity);
  }

  /**
   * <p>find by name.</p>
   *
   * @param name the name.
   * @return employment type or empty.
   */
  @Transactional
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

  /**
   * <p>delete all.</p>
   */
  @Override
  public void deleteAll() {
    this.pgEmploymentTypeRepository.deleteAll();
  }
}
