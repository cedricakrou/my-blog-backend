package com.cedricakrou.my.blog.shared.usecases;

import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import com.cedricakrou.my.blog.shared.application.command.CreateCountryCommand;
import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.PermissionRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.application.usecase.CreateCountryUseCase;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import com.cedricakrou.my.blog.shared.facade.SharedFacadeImpl;
import java.util.Optional;
import java.util.UUID;
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
 * <p>Tests of Use Case {@link CreateCountryUseCase}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
@ExtendWith(MockitoExtension.class)
class CreateCountryUseCaseTests {

  private CreateCountryUseCase useCase;
  private SharedFacade sharedFacade;
  private CountryRepository countryRepository;

  /**
   * <p>Runs before each tests.</p>
   */
  @BeforeEach
  public void setUp() {
    RoleRepository roleRepository = mock(RoleRepository.class);
    PermissionRepository permissionRepository = mock(PermissionRepository.class);
    this.countryRepository = mock(CountryRepository.class);
    this.sharedFacade = new SharedFacadeImpl(
            this.countryRepository,
            roleRepository,
            permissionRepository);
  }

  /**
   * <p>
   * Failed test to verify that Two country can't have the same name.
   * </p>
   */
  @Test
  void createCountry_Success() {

    this.useCase = new CreateCountryUseCase(this.sharedFacade);

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    // Given
    CreateCountryCommand command = new CreateCountryCommand(
            countryName,
            countryIsoCode,
            countryIndicative
    );

    // When
    this.useCase.perform(command);


    //then
    verify(countryRepository, times(1)).save(Mockito.any(Country.class));
  }

  /**
   * <p>
   * Failed test to verify that Two country can't have the same name.
   * </p>
   */
  @Test
  void createCountryWhenNameAlreadyExists_Failed() {

    this.useCase = new CreateCountryUseCase(this.sharedFacade);

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    Country country = new Country(
            UUID.randomUUID(),
            true,
            false,
            countryName,
            countryIsoCode,
            countryIndicative);

    CreateCountryCommand command = new CreateCountryCommand(
            countryName,
            countryIsoCode,
            countryIndicative
    );

    when(countryRepository.findByName(command.getName()))
            .thenReturn(Optional.of(country));

    Exception exception = Assertions.assertThrows(
            AlreadyExistsException.class,
            () -> this.useCase.perform(command)
    );

    Assertions.assertEquals(
            "Country Already exists with this name !",
            exception.getMessage());
  }

  /**
   * <p>
   * Failed test to verify that Two country can't have the same IsoCode.
   * </p>
   */
  @Test
  void createCountryWhenIsoCodeAlreadyExists_Failed() {


    this.useCase = new CreateCountryUseCase(this.sharedFacade);

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    Country country = new Country(
            UUID.randomUUID(),
            true,
            false,
            countryName,
            countryIsoCode,
            countryIndicative);

    CreateCountryCommand command = new CreateCountryCommand(
            countryName,
            countryIsoCode,
            countryIndicative
    );

    when(countryRepository.findByIsoCode(command.getIsoCode()))
            .thenReturn(Optional.of(country));

    Exception exception = Assertions.assertThrows(
            AlreadyExistsException.class,
            () -> this.useCase.perform(command)
    );

    Assertions.assertEquals(
            "Country Already exists with this iso code !",
            exception.getMessage());
  }

  /**
   * <p>
   * Failed test to verify that Two country can't have the same indicative.
   * </p>
   */
  @Test
  void createCountryWhenIndicativeAlreadyExists_Failed() {

    this.useCase = new CreateCountryUseCase(this.sharedFacade);

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    Country country = new Country(
            UUID.randomUUID(),
            true,
            false,
            countryName,
            countryIsoCode,
            countryIndicative);

    CreateCountryCommand command = new CreateCountryCommand(
            countryName,
            countryIsoCode,
            countryIndicative
    );

    when(countryRepository.findByIndicative(command.getIndicative()))
            .thenReturn(Optional.of(country));

    Exception exception = Assertions.assertThrows(
            AlreadyExistsException.class,
            () -> this.useCase.perform(command)
    );

    Assertions.assertEquals(
            "Country Already exists with this indicative !",
            exception.getMessage());
  }
}
