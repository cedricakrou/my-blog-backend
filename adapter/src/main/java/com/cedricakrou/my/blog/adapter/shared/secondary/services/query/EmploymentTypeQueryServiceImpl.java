package com.cedricakrou.my.blog.adapter.shared.secondary.services.query;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.vm.EmploymentTypeVm;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgEmploymentTypeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of EmploymentType.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
@Service
class EmploymentTypeQueryServiceImpl implements EmploymentTypeQueryService {

  private final PgEmploymentTypeRepository pgEmploymentTypeRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgEmploymentTypeRepository pg Skill repository.
   */
  EmploymentTypeQueryServiceImpl(
          final PgEmploymentTypeRepository pgEmploymentTypeRepository) {
    this.pgEmploymentTypeRepository = pgEmploymentTypeRepository;
  }

  @Override
  public List<EmploymentTypeVm> findAll() {

    return this.pgEmploymentTypeRepository.findAll()
            .stream()
            .filter(it -> !it.isDeleted())
            .map(EmploymentTypeVm::new)
            .collect(Collectors.toList());
  }
}
