package com.cedricakrou.my.blog.adapter.shared.secondary.services.query;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.vm.SkillVm;
import com.cedricakrou.my.blog.adapter.shared.secondary.repositories.jpa.PgSkillRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of Skill.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
@Service
class SkillQueryServiceImpl implements SkillQueryService {

  private final PgSkillRepository pgSkillRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param pgSkillRepository pg Skill repository.
   */
  SkillQueryServiceImpl(
          final PgSkillRepository pgSkillRepository) {
    this.pgSkillRepository = pgSkillRepository;
  }

  @Override
  public List<SkillVm> findAll() {

    return this.pgSkillRepository.findAll()
            .stream()
            .filter(it -> !it.isDeleted())
            .map(SkillVm::new)
            .collect(Collectors.toList());
  }
}
