package com.cedricakrou.my.blog.shared.usecases;

import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreateEmploymentTypeCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.EmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.application.repository.PermissionRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.application.repository.SkillRepository;
import com.cedricakrou.my.blog.shared.application.usecase.CreateEmploymentTypeUseCase;
import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
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
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@ExtendWith(MockitoExtension.class)
class CreateEmploymentTypeUseCaseTests {

  private CreateEmploymentTypeUseCase useCase;
  private EmploymentTypeRepository employmentTypeRepository;

  @BeforeEach
  void setUp() {
    SkillRepository skillRepository = mock(SkillRepository.class);
    CountryRepository countryRepository = mock(CountryRepository.class);
    RoleRepository roleRepository = mock(RoleRepository.class);
    PermissionRepository permissionRepository = mock(PermissionRepository.class);
    employmentTypeRepository = mock(EmploymentTypeRepository.class);

    SharedFacade sharedFacade = new SharedFacadeImpl(
            countryRepository,
            roleRepository,
            permissionRepository,
            this.employmentTypeRepository,
            skillRepository
    );

    this.useCase = new CreateEmploymentTypeUseCase(sharedFacade);
  }


  /**
   * <p>
   * This test must fail when we want to create Role with an incorrect command element.
   * </p>
   */
  @Test
  void createEmploymentType_shouldBeFailedWhenAtLeastOneElementOfCommandIsNotCorrect() {

    // Given
    String name = "";
    String description = "";

    CreateEmploymentTypeCommand command = new CreateEmploymentTypeCommand(
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
            "name: Employment type name is mandatory !",
            exception.getMessage());

  }

  /**
   * <p>
   * This test must be success.
   * </p>
   */
  @Test
  void createEmploymentType_shouldBeSucceed() {

    // Given
    String name = "CDI";
    String description = "";

    CreateEmploymentTypeCommand command = new CreateEmploymentTypeCommand(
            name,
            description
    );

    this.useCase.perform(command);

    // Then
    verify(this.employmentTypeRepository, times(1))
            .save(Mockito.any(EmploymentType.class));
  }

  /**
   * <p>
   * This test must fail when Role Name Exists Already.
   * </p>
   */
  @Test
  void createEmploymentType_shouldBeFailedWhenRoleNameExistsAlready() {

    // Given
    String name = "STAGE";
    String description = "";

    CreateEmploymentTypeCommand command = new CreateEmploymentTypeCommand(
            name,
            description
    );

    EmploymentType type = new EmploymentType(
            UUID.randomUUID(),
            true,
            false,
            name,
            description
    );

    when(this.employmentTypeRepository.findByName(command.getName()))
            .thenReturn(Optional.of(type));

    // When
    Exception exception = Assertions.assertThrows(
            AlreadyExistsException.class,
            () -> this.useCase.perform(command)
    );

    // Then
    Assertions.assertEquals(
            "Employment type already exists with this name !",
            exception.getMessage());

  }
}
