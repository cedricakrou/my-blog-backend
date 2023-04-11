package com.cedricakrou.my.blog.adapter.user.secondaries.facade;

import com.cedricakrou.library.security.jwt.JwtAuthenticationImpl;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of {@link UserFacade}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-24
 */
@Service
class UserFacadeImpl extends JwtAuthenticationImpl implements UserFacade {


  private final UserRepository userRepository;

  @Value("${cedricakrou.my-blog.jwt.secret-key}")
  private String jwtSecretKey;

  @Value("${cedricakrou.my-blog.jwt.expiration-duration}")
  private long jwtDuration;


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
  public Optional<User> findUserByUsername(final String username) {
    return this.userRepository.findByUsername(username);
  }

  @Override
  public void saveUser(final User user) {
    this.userRepository.save(user);
  }

  @Override
  public String createToken(final User user) {

    return generateToken(
            user.getEmail(),
            jwtSecretKey,
            jwtDuration
    );
  }
}
