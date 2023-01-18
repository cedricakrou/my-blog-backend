package com.cedricakrou.my.blog.shared.usecases;

import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreateRoleCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.application.usecase.CreateRoleUseCase;
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
 * <p>Tests of Use Case {@link CreateRoleUseCase}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-17
 */
@ExtendWith(MockitoExtension.class)
class CreateRoleUseCaseTests {

  private CreateRoleUseCase useCase;
  private RoleRepository roleRepository;

  /**
   * <p>Run before each test.</p>
   */
  @BeforeEach
  public void setUp() {

    CountryRepository countryRepository = mock(CountryRepository.class);
    this.roleRepository = mock(RoleRepository.class);

    SharedFacade sharedFacade = new SharedFacadeImpl(
            countryRepository,
            this.roleRepository
    );
    this.useCase = new CreateRoleUseCase(sharedFacade);

    this.roleRepository.deleteAll();
  }

  /**
   * <p>
   * This test must fail when we want to create Role with an incorrect command element.
   * </p>
   */
  @Test
  void createRole_shouldBeFailedWhenAtLeastOneElementOfCommandIsNotCorrect() {

    // Given
    String name = "";
    String description = "";

    CreateRoleCommand command = new CreateRoleCommand(
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
            "name: Role name is mandatory !",
            exception.getMessage());

  }

  /**
   * <p>
   * This test must be success.
   * </p>
   */
  @Test
  void createRole_shouldBeSucceed() {

    // Given
    String name = "ADMIN";
    String description = "Admin role";

    // When
    CreateRoleCommand command = new CreateRoleCommand(
            name,
            description
    );

    this.useCase.perform(command);

    // Then
    verify(roleRepository, times(1)).save(Mockito.any(Role.class));
  }

  /**
   * <p>
   * This test must fail when Role Name Exists Already.
   * </p>
   */
  @Test
  void createRole_shouldBeFailedWhenRoleNameExistsAlready() {

    // Given
    String name = "ADMIN";
    String description = "Admin role";


    CreateRoleCommand command = new CreateRoleCommand(
            name,
            description
    );

    Role role = new Role(
            UUID.randomUUID(),
            false,
            true,
            name,
            description,
            new Permission[]{});

    when(roleRepository.findByName(command.getName()))
            .thenReturn(Optional.of(role));

    // When
    Exception exception = Assertions.assertThrows(
            AlreadyExistsException.class,
            () -> this.useCase.perform(command)
    );

    // Then
    Assertions.assertEquals(
            "Role already exists with this name !",
            exception.getMessage());

  }
}
