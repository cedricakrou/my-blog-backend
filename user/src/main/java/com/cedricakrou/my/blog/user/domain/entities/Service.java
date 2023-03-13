package com.cedricakrou.my.blog.user.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.AbstractEntityBuilder;
import com.cedricakrou.library.generic.aggregate.domain.DomainEntityRoot;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Entity representing Services offer by user.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-07
 */
@Getter
public class Service extends DomainEntityRoot {
  private final int order;
  private final String title;
  private final String description;
  private final String imageUrl;

  /**
   * <p>Entity constructor.</p>
   *
   * @param builder ServiceBuilder.
   */
  private Service(final ServiceBuilder builder) {
    super(builder.getId(), builder.isEnabled(), builder.isDeleted());
    this.order = builder.order;
    this.title = builder.title;
    this.description = builder.description;
    this.imageUrl = builder.imageUrl;
  }

  public static class ServiceBuilder extends AbstractEntityBuilder<Service> {

    private int order;
    private String title;
    private String description;
    private String imageUrl;

    /**
     * <p>Default constructor.</p>
     *
     * @param id      Identifier.
     * @param enabled enabled.
     * @param deleted deleted.
     */
    protected ServiceBuilder(
            final UUID id,
            final boolean enabled,
            final boolean deleted) {
      super(id, enabled, deleted);
    }

    /**
     * <p>Change order Value.</p>
     *
     * @param order order.
     * @return ServiceBuilder
     */
    public ServiceBuilder setOrder(final int order) {
      this.order = order;
      return this;
    }

    /**
     * <p>Change title Value.</p>
     *
     * @param title title.
     * @return ServiceBuilder
     */
    public ServiceBuilder setTitle(final String title) {
      this.title = title;
      return this;
    }

    /**
     * <p>Change description Value.</p>
     *
     * @param description description.
     * @return ServiceBuilder
     */
    public ServiceBuilder setDescription(final String description) {
      this.description = description;
      return this;
    }

    /**
     * <p>Change imageUrl Value.</p>
     *
     * @param imageUrl imageUrl.
     * @return ServiceBuilder
     */
    public ServiceBuilder setImageUrl(final String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    /**
     * <p>To build Service instance.</p>
     *
     * @return Service
     */
    @Override
    public Service buildEntity() {
      return new Service(this);
    }
  }
}
