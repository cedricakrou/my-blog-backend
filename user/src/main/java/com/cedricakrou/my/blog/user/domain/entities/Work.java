package com.cedricakrou.my.blog.user.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.AbstractEntityBuilder;
import com.cedricakrou.library.generic.aggregate.domain.DomainEntityRoot;
import com.cedricakrou.my.blog.user.domain.value.objects.Skill;
import java.util.UUID;

/**
 * <p>Entity representing User works.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-07
 */
public class Work extends DomainEntityRoot {

  private final String title;
  private final String description;
  private final String[] images;
  private final Skill[] skills;
  private final Service service;

  private Work(final WorkBuilder builder) {
    super(builder.getId(), builder.isEnabled(), builder.isDeleted());
    this.title = builder.title;
    this.description = builder.description;
    this.images = builder.images;
    this.skills = builder.skills;
    this.service = builder.service;
  }

  public static class WorkBuilder extends AbstractEntityBuilder<Work> {

    private String title;
    private String description;
    private String[] images;
    private Skill[] skills;
    private Service service;

    /**
     * <p>Default constructor.</p>
     *
     * @param id      Identifier.
     * @param enabled enabled.
     * @param deleted deleted.
     */
    protected WorkBuilder(final UUID id,
                          final boolean enabled,
                          final boolean deleted) {
      super(id, enabled, deleted);
    }

    /**
     * <p>To change Title value.</p>
     *
     * @param title title
     * @return WorkBuilder.
     */
    public WorkBuilder setTitle(final String title) {
      this.title = title;
      return this;
    }

    /**
     * <p>To change description value.</p>
     *
     * @param description title
     * @return WorkBuilder.
     */
    public WorkBuilder setDescription(final String description) {
      this.description = description;
      return this;
    }

    /**
     * <p>To change images value.</p>
     *
     * @param images images
     * @return WorkBuilder.
     */
    public WorkBuilder setImages(final String[] images) {
      this.images = images;
      return this;
    }

    /**
     * <p>To change skills value.</p>
     *
     * @param skills skills.
     * @return WorkBuilder.
     */
    public WorkBuilder setSkills(final Skill[] skills) {
      this.skills = skills;
      return this;
    }

    /**
     * <p>To change service value.</p>
     *
     * @param service service.
     * @return WorkBuilder.
     */
    public WorkBuilder setService(final Service service) {
      this.service = service;
      return this;
    }

    /**
     * <p>To build work new instances.</p>
     *
     * @return Work.
     **/
    @Override
    public Work buildEntity() {
      return null;
    }
  }
}
