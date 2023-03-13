package com.cedricakrou.my.blog.user.application.repositories;

import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.Optional;

/**
 * <p>User Repository.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
public interface UserRepository {

  /**
   * <p>Find user by email.</p>
   *
   * @param email email.
   * @return user or empty.
   */
  Optional<User> findByEmail(String email);

  /**
   * <p>Find user by usermane.</p>
   *
   * @param username username.
   * @return user or empty.
   */
  Optional<User> findByUsername(String username);

  /**
   * <p>Find user by email or username .</p>
   *
   * @param email    email.
   * @param username username.
   * @return user or empty.
   */
  Optional<User> findByEmailOrUsername(String email, String username);

  /**
   * <p>Save a new user.</p>
   *
   * @param user user.
   */
  void save(User user);

}
