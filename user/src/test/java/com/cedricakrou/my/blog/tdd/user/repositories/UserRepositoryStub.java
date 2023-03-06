package com.cedricakrou.my.blog.tdd.user.repositories;

import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.domain.entities.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author KAKOU Akrou Cedric 2023-03-03
 */
public class UserRepositoryStub implements UserRepository {

  private final Map<UUID, User> db = new HashMap<UUID, User>();

  @Override
  public Optional<User> findByEmail(String email) {

    for (User user : db.values()) {

      if (user.getEmail().equals(email)) {

        return Optional.of(user);
      }
    }

    return Optional.empty();
  }

  @Override
  public Optional<User> findByUsername(String username) {

    for (User user : db.values()) {

      if (user.getUsername().equals(username)) {

        return Optional.of(user);
      }
    }

    return Optional.empty();
  }

  @Override
  public Optional<User> findByEmailOrUsername(String email, String username) {

    for (User user : db.values()) {

      if (user.getEmail().equals(email) || user.getUsername().equals(username)) {

        return Optional.of(user);
      }
    }

    return Optional.empty();
  }

  @Override
  public void save(User user) {
    this.db.put(user.getId(), user);
  }
}
