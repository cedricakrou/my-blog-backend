package com.cedricakrou.my.blog.shared.usecases;

import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreatePermissionCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.EmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.application.repository.PermissionRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.application.repository.SkillRepository;
import com.cedricakrou.my.blog.shared.application.usecase.CreatePermissionUseCase;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
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
class CreatePermissionUseCaseTests {

  private CreatePermissionUseCase useCase;
  private PermissionRepository permissionRepository;

  /**
   * <p>Run before each test.</p>
   */
  @BeforeEach
  void setUp() {
    SkillRepository skillRepository = mock(SkillRepository.class);
    EmploymentTypeRepository employmentTypeRepository = mock(EmploymentTypeRepository.class);
    CountryRepository countryRepository = mock(CountryRepository.class);
    RoleRepository roleRepository = mock(RoleRepository.class);
    permissionRepository = mock(PermissionRepository.class);

    SharedFacade sharedFacade = new SharedFacadeImpl(
            countryRepository,
            roleRepository,
            this.permissionRepository,
            employmentTypeRepository,
            skillRepository
    );
    this.useCase = new CreatePermissionUseCase(sharedFacade);

    roleRepository.deleteAll();
  }

  /**
   * <p>
   * This test must fail when we want to create Role with an incorrect command element.
   * </p>
   */
  @Test
  void createPermission_shouldBeFailedWhenAtLeastOneElementOfCommandIsNotCorrect() {

    // Given
    String name = "";
    String description = "";

    CreatePermissionCommand command = new CreatePermissionCommand(
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
            "name: Permission name is mandatory !",
            exception.getMessage());

  }

  /**
   * <p>
   * This test must be success.
   * </p>
   */
  @Test
  void createPermission_shouldBeSucceed() {

    // Given
    String name = "Read";
    String description = "Read permission";

    // When
    CreatePermissionCommand command = new CreatePermissionCommand(
            name,
            description
    );

    this.useCase.perform(command);

    // Then
    verify(permissionRepository, times(1)).save(Mockito.any(Permission.class));
  }

  /**
   * <p>
   * This test must fail when we want to create Permission with an incorrect command element.
   * </p>
   */
  @Test
  void createPermission_shouldBeFailedWhenPermissionNameExistsAlready() {

    // Given
    String name = "ADMIN";
    String description = "Admin role";


    CreatePermissionCommand command = new CreatePermissionCommand(
            name,
            description
    );

    Permission permission = new Permission(
            UUID.randomUUID(),
            false,
            true,
            name,
            description,
            new Role[]{});

    when(permissionRepository.findByName(command.getName()))
            .thenReturn(Optional.of(permission));

    // When
    Exception exception = Assertions.assertThrows(
            AlreadyExistsException.class,
            () -> this.useCase.perform(command)
    );

    // Then
    Assertions.assertEquals(
            "Permission already exists with this name !",
            exception.getMessage());
  }

}
