package com.cedricakrou.my.blog.user.facade;

import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.Optional;

/**
 * <p>Implementation of {@link UserFacade}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-23
 */
public class UserFacadeImpl implements UserFacade {

  private final UserRepository userRepository;

  public UserFacadeImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isUserCredentialsExists(String email, String username) {

    Optional<User> user = this.userRepository.findByEmailOrUsername(email);

    return user.isPresent() && !user.get().isDeleted();
  }

  @Override
  public Optional<User> findUserByEmail(String email) {
    return this.userRepository.findByEmailOrUsername(email);
  }

  @Override
  public void saveUser(User user) {
    this.userRepository.save(user);
  }
}
