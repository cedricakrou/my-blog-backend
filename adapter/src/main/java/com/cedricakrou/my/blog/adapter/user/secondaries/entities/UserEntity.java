package com.cedricakrou.my.blog.adapter.user.secondaries.entities;

import com.cedricakrou.library.generic.adapter.DatabaseEntityRoot;
import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;

/**
 * <p>User entity.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-24
 */
@Entity
@Table(name = "user")
@Getter
public class UserEntity extends DatabaseEntityRoot<User> {

  @Column(name = "email", unique = true)
  private String email;
  @Column(name = "username", unique = true)
  private String username;
  @Column(name = "password", nullable = false)
  private String password;

  /**
   * <p>Default constructor.</p>
   */
  public UserEntity() {
    super(null, true, false);
  }

  /**
   * <p>Secondary Constructor.</p>
   *
   * @param id       Id.
   * @param enabled  Enabled
   * @param deleted  Deleted.
   * @param email    email.
   * @param username username.
   * @param password password.
   */
  public UserEntity(final UUID id,
                    final boolean enabled,
                    final boolean deleted,
                    final String email,
                    final String username,
                    final String password) {
    super(id, enabled, deleted);
    this.email = email;
    this.username = username;
    this.password = password;
  }

  /**
   * <p>Create database entity from domain entity.</p>
   *
   * @param user domain.
   * @return user database.
   */
  public static UserEntity from(final User user) {

    return new UserEntity(user.getId(),
            user.isEnabled(),
            user.isDeleted(),
            user.getEmail(),
            user.getUsername(),
            user.getPassword());
  }

  /**
   * <p>Transform database entity to domain entity.</p>
   *
   * @return user domain.
   */
  @Override
  public User toDomain() {

    return new User.UserBuilder(
            super.getId(),
            super.isEnabled(),
            super.isDeleted())
            .setEmail(this.email)
            .setUsername(this.username)
            .setPassword(this.password)
            .buildEntity();
  }
}
