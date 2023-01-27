package com.cedricakrou.my.blog.adapter.integration.test.shared.impl;

import com.cedricakrou.my.blog.adapter.shared.secondaries.entities.SkillEntity;
import com.cedricakrou.my.blog.adapter.shared.secondaries.repositories.jpa.PgSkillRepository;
import com.cedricakrou.my.blog.shared.application.repository.SkillRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Skill;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * <p>Skill service.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Service
class SkillRepositoryImpl implements SkillRepository {

  private final PgSkillRepository pgSkillRepository;

  SkillRepositoryImpl(final PgSkillRepository pgSkillRepository) {
    this.pgSkillRepository = pgSkillRepository;
  }

  @Override
  public Optional<Skill> findByName(final String name) {

    Optional<SkillEntity> optionalSkillEntity =
            this.pgSkillRepository.findByName(name);

    if (optionalSkillEntity.isPresent()) {
      Skill skill = optionalSkillEntity.get().toDomain();

      return Optional.of(skill);
    }

    return Optional.empty();
  }

  @Transactional
  @Override
  public void save(final Skill skill) {
    SkillEntity skillEntity = SkillEntity.from(skill);
    this.pgSkillRepository.save(skillEntity);
  }

  @Override
  public void deleteAll() {
    this.pgSkillRepository.deleteAll();
  }
}
