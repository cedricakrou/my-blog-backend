package com.cedricakrou.my.blog.adapter.user.secondaries.facade;

import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of {@link UserFacade}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-24
 */
@Service
class UserFacadeImpl implements UserFacade {


  private final UserRepository userRepository;

  /**
   * <p>Default constructor.</p>
   *
   * @param userRepository User Repository.
   */
  UserFacadeImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isUserCredentialsExists(final String email,
                                         final String username) {

    Optional<User> optionalUser =
            this.userRepository.findByEmailOrUsername(email, username);

    return optionalUser.isPresent() && !optionalUser.get().isDeleted();
  }

  @Override
  public Optional<User> findUserByEmail(final String email) {
    return this.userRepository.findByEmail(email);
  }

  @Override
  public void saveUser(final User user) {
    this.userRepository.save(user);
  }
}
