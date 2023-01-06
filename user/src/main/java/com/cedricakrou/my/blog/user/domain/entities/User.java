package com.cedricakrou.my.blog.user.domain.entities;

import com.cedricakrou.library.generic.aggregate.AbstractEntityBuilder;
import com.cedricakrou.library.generic.aggregate.Entity;
import com.cedricakrou.my.blog.user.domain.value.objects.Address;
import java.util.UUID;

/**
 * <p>Entity representing User.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
public class User extends Entity {

  private final String firstname;
  private final String lastname;
  private final String email;
  private final String[] phones;
  private final Address address;

  private User(final UserBuilder builder) {
    super(builder.getId(), builder.isEnabled(), builder.isDeleted());
    this.firstname = builder.firstname;
    this.lastname = builder.lastname;
    this.email = builder.email;
    this.phones = builder.phones;
    this.address = builder.address;
  }

  public static class UserBuilder extends AbstractEntityBuilder<User> {
    private String firstname;
    private String lastname;
    private String email;
    private String[] phones;
    private Address address;

    /**
     * <p>Default constructor.</p>
     *
     * @param id      Identifier.
     * @param enabled enabled.
     * @param deleted deleted.
     */
    protected UserBuilder(
            final UUID id,
            final boolean enabled,
            final boolean deleted) {
      super(id, enabled, deleted);
    }

    /**
     * <p>Change Firstname value.</p>
     *
     * @param firstname firstname.
     * @return UserBuilder.
     **/
    public UserBuilder setFirstname(final String firstname) {
      this.firstname = firstname;
      return this;
    }

    /**
     * <p>Change Lastname value.</p>
     *
     * @param lastname lastname.
     * @return UserBuilder.
     **/
    public UserBuilder setLastname(final String lastname) {
      this.lastname = lastname;
      return this;
    }

    /**
     * <p>Change Email value.</p>
     *
     * @param email email.
     * @return UserBuilder.
     **/
    public UserBuilder setEmail(final String email) {
      this.email = email;
      return this;
    }

    /**
     * <p>Change Phones value.</p>
     *
     * @param phones phones.
     * @return UserBuilder.
     **/
    public UserBuilder setPhones(final String[] phones) {
      this.phones = phones;
      return this;
    }

    /**
     * <p>Change Address value.</p>
     *
     * @param address firstname.
     * @return UserBuilder.
     **/
    public UserBuilder setAddress(final Address address) {
      this.address = address;
      return this;
    }

    /**
     * <p>Build an instance of User.</p>
     *
     * @return User
     */
    @Override
    public User buildEntity() {
      return new User(this);
    }
  }
}
