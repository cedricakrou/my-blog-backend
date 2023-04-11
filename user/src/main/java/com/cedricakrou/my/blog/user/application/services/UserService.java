package com.cedricakrou.my.blog.user.application.services;

import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.Optional;

/**
 * <p>User service.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
public interface UserService {

  /**
   * <p>check if user exists and is valid and database.</p>
   *
   * @param email    email.
   * @param username username.
   * @return user or empty.
   */
  boolean isUserCredentialsExists(String email, String username);

  /**
   * <p>Find user by email.</p>
   *
   * @param email email.
   * @return user or empty.
   */
  Optional<User> findUserByEmail(String email);

  /**
   * <p>Find user by email.</p>
   *
   * @param username username.
   * @return user or empty.
   */
  Optional<User> findUserByUsername(String username);

  /**
   * <p>Save user.</p>
   *
   * @param user user to save.
   */
  void saveUser(User user);

  /**
   * <p>Create token.</p>
   *
   * @param user user.
   * @return token.
   */
  String createToken(User user);
}
