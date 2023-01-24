package com.cedricakrou.my.blog.adapter.user.secondaries.repositories.jpa;

import com.cedricakrou.my.blog.adapter.user.secondaries.entities.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Jpa Repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-24
 */
@Repository
public interface PgUserRepository extends JpaRepository<UserEntity, UUID> {

  /**
   * <p>Find user by email.</p>
   *
   * @param email email.
   * @return user or empty.
   */
  Optional<UserEntity> findByEmail(String email);

  /**
   * <p>Find user by email or username.</p>
   *
   * @param email    email.
   * @param username username.
   * @return user or empty.
   */
  Optional<UserEntity> findByEmailOrUsername(String email, String username);
}
