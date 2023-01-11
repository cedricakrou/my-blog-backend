package com.cedricakrou.my.blog.user.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.AbstractEntityBuilder;
import com.cedricakrou.library.generic.aggregate.domain.Entity;
import java.util.UUID;

/**
 * <p>Entity representing User social Media.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-07
 */
public class SocialMedia extends Entity {

  private final String label;
  private final String link;
  private final String content;
  private final String imageUrl;

  /**
   * <p>Default constructor.</p>
   *
   * @param builder SocialMedia.
   */
  public SocialMedia(final SocialMediaBuilder builder) {
    super(builder.getId(), builder.isEnabled(), builder.isDeleted());
    this.label = builder.label;
    this.link = builder.link;
    this.content = builder.content;
    this.imageUrl = builder.imageUrl;
  }

  public static class SocialMediaBuilder extends
          AbstractEntityBuilder<SocialMedia> {
    private String label;
    private String link;
    private String content;
    private String imageUrl;

    /**
     * <p>Default constructor.</p>
     *
     * @param id      Identifier.
     * @param enabled enabled.
     * @param deleted deleted.
     */
    protected SocialMediaBuilder(
            final UUID id,
            final boolean enabled,
            final boolean deleted) {
      super(id, enabled, deleted);
    }

    /**
     * <p>To change label value.</p>
     *
     * @param label label.
     * @return SocialMediaBuilder.
     */
    public SocialMediaBuilder label(final String label) {
      this.label = label;
      return this;
    }

    /**
     * <p>To change link value.</p>
     *
     * @param link link.
     * @return SocialMediaBuilder.
     */
    public SocialMediaBuilder link(final String link) {
      this.link = link;
      return this;
    }

    /**
     * <p>To change content value.</p>
     *
     * @param content label.
     * @return SocialMediaBuilder.
     */
    public SocialMediaBuilder content(final String content) {
      this.content = content;
      return this;
    }

    /**
     * <p>To change imageUrl value.</p>
     *
     * @param imageUrl image url.
     * @return SocialMediaBuilder.
     */
    public SocialMediaBuilder imageUrl(final String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    /**
     * <p>Creating social media instance.</p>
     *
     * @return SocialMedia.
     */
    @Override
    public SocialMedia buildEntity() {
      return new SocialMedia(this);
    }
  }
}
