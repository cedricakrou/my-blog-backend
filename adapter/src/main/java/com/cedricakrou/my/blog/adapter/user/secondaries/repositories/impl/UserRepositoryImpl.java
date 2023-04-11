package com.cedricakrou.my.blog.adapter.user.secondaries.repositories.impl;

import com.cedricakrou.my.blog.adapter.user.secondaries.entities.UserEntity;
import com.cedricakrou.my.blog.adapter.user.secondaries.repositories.jpa.PgUserRepository;
import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of {@link UserRepository}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-24
 */
@Service
class UserRepositoryImpl implements UserRepository {

  private final PgUserRepository pgUserRepository;

  UserRepositoryImpl(final PgUserRepository pgUserRepository) {
    this.pgUserRepository = pgUserRepository;
  }

  @Override
  public Optional<User> findByEmail(final String email) {

    Optional<UserEntity> optionalUserEntity =
            this.pgUserRepository.findByEmail(email);

    return userEntityToUserDomain(optionalUserEntity);
  }

  @Override
  public Optional<User> findByUsername(final String username) {

    Optional<UserEntity> optionalUserEntity =
            this.pgUserRepository.findByUsername(username);

    return userEntityToUserDomain(optionalUserEntity);
  }

  @Override
  public Optional<User> findByEmailOrUsername(final String email,
                                              final String username) {

    Optional<UserEntity> optionalUserEntity =
            this.pgUserRepository.findByEmailOrUsername(email, username);

    return userEntityToUserDomain(optionalUserEntity);
  }

  @Override
  public void save(final User user) {

    UserEntity userEntity = UserEntity.from(user);

    this.pgUserRepository.save(userEntity);
  }

  /**
   * <p>Transform optional user entities into optional user domains.</p>
   *
   * @param optionalUserEntity optional user entity.
   * @return user or empty.
   */
  private Optional<User> userEntityToUserDomain(
          final Optional<UserEntity> optionalUserEntity) {

    if (optionalUserEntity.isPresent()) {

      UserEntity userEntity = optionalUserEntity.get();

      User user = userEntity.toDomain();

      return Optional.of(user);
    }

    return Optional.empty();
  }
}
