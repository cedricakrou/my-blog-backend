package com.cedricakrou.my.blog.adapter.shared.primaries.facade;

import com.cedricakrou.my.blog.shared.application.facade.SharedFacade;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.application.repository.EmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.application.repository.PermissionRepository;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.application.repository.SkillRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
import com.cedricakrou.my.blog.shared.domain.entities.Skill;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p>SharedFacade implementation.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
@Service
class SharedFacadeAdapter implements SharedFacade {

  private final RoleRepository roleRepository;
  private final CountryRepository countryRepository;
  private final PermissionRepository permissionRepository;
  private final EmploymentTypeRepository employmentTypeRepository;
  private final SkillRepository skillRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param roleRepository           role repository.
   * @param countryRepository        country repository.
   * @param permissionRepository     permission repository.
   * @param employmentTypeRepository employment type repository.
   * @param skillRepository          skill repository.
   */
  SharedFacadeAdapter(final RoleRepository roleRepository,
                      final CountryRepository countryRepository,
                      final PermissionRepository permissionRepository,
                      final EmploymentTypeRepository employmentTypeRepository,
                      final SkillRepository skillRepository) {
    this.roleRepository = roleRepository;
    this.countryRepository = countryRepository;
    this.permissionRepository = permissionRepository;
    this.employmentTypeRepository = employmentTypeRepository;
    this.skillRepository = skillRepository;
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

  @Override
  public Optional<EmploymentType> findEmploymentTypeByName(final String name) {
    return this.employmentTypeRepository.findByName(name);
  }

  @Override
  public void addEmploymentType(final EmploymentType type) {
    this.employmentTypeRepository.save(type);
  }

  @Override
  public Optional<Skill> findSkillByName(final String name) {
    return this.skillRepository.findByName(name);
  }

  @Override
  public void addSkill(final Skill skill) {
    this.skillRepository.save(skill);
  }
}
