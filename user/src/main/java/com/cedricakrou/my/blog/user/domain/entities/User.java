package com.cedricakrou.my.blog.user.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.AbstractEntityBuilder;
import com.cedricakrou.library.generic.aggregate.domain.DomainEntityRoot;
import com.cedricakrou.my.blog.user.domain.value.objects.Address;
import com.cedricakrou.my.blog.user.domain.value.objects.Role;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Entity representing User.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
@Getter
public class User extends DomainEntityRoot {

  private final String firstname;
  private final String lastname;
  private final String email;
  private final String username;
  private final String[] phones;
  private final Address address;
  private final Role role;
  private final Menu[] menus;
  private final Experience[] experiences;
  private final SocialMedia[] socialMedias;
  private final Service services;
  private final String briefDescription;
  private final String workDescription;
  private final Experience currentJob;
  private final Work[] works;
  private final String cvLink;
  private final String password;
  private final boolean loggedIn;

  private User(final UserBuilder builder) {
    super(builder.getId(), builder.isEnabled(), builder.isDeleted());
    this.firstname = builder.firstname;
    this.lastname = builder.lastname;
    this.email = builder.email;
    this.username = builder.username;
    this.phones = builder.phones;
    this.address = builder.address;
    this.role = builder.role;
    this.menus = builder.menus;
    this.experiences = builder.experiences;
    this.socialMedias = builder.socialMedias;
    this.services = builder.services;
    this.briefDescription = builder.briefDescription;
    this.workDescription = builder.workDescription;
    this.currentJob = builder.currentJob;
    this.works = builder.works;
    this.cvLink = builder.cvLink;
    this.password = builder.password;
    this.loggedIn = builder.loggedIn;
  }

  public static class UserBuilder extends AbstractEntityBuilder<User> {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String[] phones;
    private Address address;
    private Role role;
    private Menu[] menus;
    private Experience[] experiences;
    private SocialMedia[] socialMedias;
    private Service services;
    private String briefDescription;
    private String workDescription;
    private Experience currentJob;
    private Work[] works;
    private String cvLink;
    private String password;
    private boolean loggedIn;

    /**
     * <p>Constructor uses to create object.</p>
     *
     * @param id      Identifier.
     * @param enabled enabled.
     * @param deleted deleted.
     */
    public UserBuilder(
            final UUID id,
            final boolean enabled,
            final boolean deleted) {
      super(id, enabled, deleted);
    }

    /**
     * <p>Constructor uses to modify object.</p>
     */
    public UserBuilder(
            User user
    ) {
      super(user.getId(), user.isEnabled(), user.isDeleted());
      setFirstname(user.getFirstname());
      setLastname(user.getLastname());
      setEmail(user.getEmail());
      setUsername(user.getUsername());
      setPhones(user.getPhones());
      setAddress(user.getAddress());
      setRole(user.getRole());
      setMenus(user.getMenus());
      setExperiences(user.getExperiences());
      setSocialMedias(user.getSocialMedias());
      setServices(user.getServices());
      setBriefDescription(user.getBriefDescription());
      setWorkDescription(user.getWorkDescription());
      setCurrentJob(user.getCurrentJob());
      setWorks(user.getWorks());
      setCvLink(user.getCvLink());
      setPassword(user.getPassword());
      setLoggedIn(user.isLoggedIn());
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
     * <p>Change Username value.</p>
     *
     * @param username username.
     * @return UserBuilder.
     **/
    public UserBuilder setUsername(final String username) {
      this.username = username;
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
     * <p>Change User role.</p>
     *
     * @param role User role.
     * @return UserBuilder.
     **/
    public UserBuilder setRole(final Role role) {
      this.role = role;
      return this;
    }

    /**
     * <p>Change Menu value.</p>
     *
     * @param menus user menu.
     * @return UserBuilder.
     **/
    public UserBuilder setMenus(final Menu[] menus) {
      this.menus = menus;
      return this;
    }

    /**
     * <p>Change experiences value.</p>
     *
     * @param experiences experiences.
     * @return UserBuilder.
     **/
    public UserBuilder setExperiences(final Experience[] experiences) {
      this.experiences = experiences;
      return this;
    }

    /**
     * <p>Change socialMedias value.</p>
     *
     * @param socialMedias socialMedias.
     * @return UserBuilder.
     **/
    public UserBuilder setSocialMedias(final SocialMedia[] socialMedias) {
      this.socialMedias = socialMedias;
      return this;
    }

    /**
     * <p>Change services value.</p>
     *
     * @param services services.
     * @return UserBuilder.
     **/
    public UserBuilder setServices(final Service services) {
      this.services = services;
      return this;
    }

    /**
     * <p>Change briefDescription value.</p>
     *
     * @param briefDescription brief description.
     * @return UserBuilder.
     **/
    public UserBuilder setBriefDescription(final String briefDescription) {
      this.briefDescription = briefDescription;
      return this;
    }

    /**
     * <p>Change work description value.</p>
     *
     * @param workDescription work description.
     * @return UserBuilder.
     **/
    public UserBuilder setWorkDescription(final String workDescription) {
      this.workDescription = workDescription;
      return this;
    }

    /**
     * <p>Change currentJob value.</p>
     *
     * @param currentJob currentJob.
     * @return UserBuilder.
     **/
    public UserBuilder setCurrentJob(final Experience currentJob) {
      this.currentJob = currentJob;
      return this;
    }

    /**
     * <p>Change works value.</p>
     *
     * @param works works.
     * @return UserBuilder.
     **/
    public UserBuilder setWorks(final Work[] works) {
      this.works = works;
      return this;
    }

    /**
     * <p>Change cv link value.</p>
     *
     * @param cvLink link of cv.
     * @return UserBuilder.
     **/
    public UserBuilder setCvLink(final String cvLink) {
      this.cvLink = cvLink;
      return this;
    }

    /**
     * <p>Update password value.</p>
     *
     * @param password password.
     * @return UserBuilder.
     */
    public UserBuilder setPassword(final String password) {
      this.password = password;
      return this;
    }

    /**
     * <p>Update login value.</p>
     *
     * @param loggedIn login.
     * @return UserBuilder.
     */
    public UserBuilder setLoggedIn(boolean loggedIn) {
      this.loggedIn = loggedIn;
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
