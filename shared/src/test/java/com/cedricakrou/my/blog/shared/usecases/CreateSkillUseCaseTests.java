package com.cedricakrou.my.blog.shared.usecases;

import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreateSkillCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.EmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.application.repository.PermissionRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.application.repository.SkillRepository;
import com.cedricakrou.my.blog.shared.application.usecase.CreateSkillUseCase;
import com.cedricakrou.my.blog.shared.domain.entities.Skill;
import com.cedricakrou.my.blog.shared.facade.SharedFacadeImpl;
import java.util.Optional;
import java.util.UUID;
import javax.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * <p>Tests Of the skill creating.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@ExtendWith(MockitoExtension.class)
class CreateSkillUseCaseTests {

  private CreateSkillUseCase useCase;
  private SkillRepository skillRepository;

  @BeforeEach
  void setUp() {
    EmploymentTypeRepository employmentTypeRepository = mock(EmploymentTypeRepository.class);
    CountryRepository countryRepository = mock(CountryRepository.class);
    RoleRepository roleRepository = mock(RoleRepository.class);
    PermissionRepository permissionRepository = mock(PermissionRepository.class);
    this.skillRepository = mock(SkillRepository.class);
    SharedFacade sharedFacade = new SharedFacadeImpl(
            countryRepository,
            roleRepository,
            permissionRepository,
            employmentTypeRepository,
            this.skillRepository
    );

    this.useCase = new CreateSkillUseCase(sharedFacade);
  }

  @Test
  void createSkill_shouldBeFailedWhenAtLeastOneElementOfCommandIsNotCorrect() {

    // Given
    String name = "";
    String description = "";


    CreateSkillCommand command = new CreateSkillCommand(
            name,
            description
    );

    // When
    Exception exception = Assertions.assertThrows(
            ConstraintViolationException.class,
            () -> this.useCase.perform(command)
    );

    // Then
    Assertions.assertEquals(
            "name: Skill name is mandatory !",
            exception.getMessage());
  }

  @Test
  void createSkill_shouldBeSucceed() {

    // Given
    String name = "Java";
    String description = "java";


    CreateSkillCommand command = new CreateSkillCommand(
            name,
            description
    );

    // When
    this.useCase.perform(command);

    // Then
    verify(this.skillRepository, times(1))
            .save(Mockito.any(Skill.class));
  }

  /**
   * <p>
   * This test must fail when Skill Name Exists Already.
   * </p>
   */
  @Test
  void createSkill_shouldBeFailedWhenRoleNameExistsAlready() {

    // Given
    String name = "Java";
    String description = "java";


    CreateSkillCommand command = new CreateSkillCommand(
            name,
            description
    );

    Skill skill = new Skill(
            UUID.randomUUID(),
            false,
            true,
            name,
            description);

    when(this.skillRepository.findByName(command.getName()))
            .thenReturn(Optional.of(skill));

    // When
    Exception exception = Assertions.assertThrows(
            AlreadyExistsException.class,
            () -> this.useCase.perform(command)
    );

    // Then
    Assertions.assertEquals(
            "Skill already exists with this name !",
            exception.getMessage());

  }
}
