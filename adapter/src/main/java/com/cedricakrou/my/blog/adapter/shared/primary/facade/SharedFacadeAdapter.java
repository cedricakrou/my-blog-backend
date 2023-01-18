package com.cedricakrou.my.blog.adapter.shared.primary.facade;

import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.PermissionRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p>SharedFacade implementation.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
@Service
public final class SharedFacadeAdapter implements SharedFacade {

  private final CountryRepository countryRepository;
  private final RoleRepository roleRepository;
  private final PermissionRepository permissionRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param countryRepository    country repository.
   * @param roleRepository       role repository.
   * @param permissionRepository permission repository.
   */
  public SharedFacadeAdapter(final CountryRepository countryRepository,
                             final RoleRepository roleRepository,
                             final PermissionRepository permissionRepository) {
    this.countryRepository = countryRepository;
    this.roleRepository = roleRepository;
    this.permissionRepository = permissionRepository;
  }

  @Override
  public Optional<Country> findByCountryId(final UUID id) {

    return this.countryRepository.findById(id);
  }

  @Override
  public Optional<Country> findByCountryName(final String name) {

    return this.countryRepository.findByName(name);
  }

  @Override
  public Optional<Country> findByCountryIsoCode(final String isoCode) {

    return this.countryRepository.findByIsoCode(isoCode);
  }

  @Override
  public Optional<Country> findByCountryIndicative(final int indicative) {

    return this.countryRepository.findByIndicative(indicative);
  }

  @Override
  public void saveCountry(final Country country) {
    this.countryRepository.save(country);
  }

  @Override
  public Optional<Role> findRoleByName(final String roleName) {
    return this.roleRepository.findByName(roleName);
  }

  @Override
  public void addRole(final Role role) {
    this.roleRepository.save(role);
  }

  @Override
  public void deleteAll() {
    this.roleRepository.deleteAll();
  }

  @Override
  public Optional<Permission> findPermissionByName(final String name) {
    return this.permissionRepository.findByName(name);
  }

  @Override
  public void addPermission(final Permission permission) {
    this.permissionRepository.save(permission);
  }
}
