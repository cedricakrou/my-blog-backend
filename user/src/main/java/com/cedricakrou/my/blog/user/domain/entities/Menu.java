package com.cedricakrou.my.blog.user.domain.entities;

import com.cedricakrou.library.generic.aggregate.AbstractEntityBuilder;
import com.cedricakrou.library.generic.aggregate.Entity;
import java.util.UUID;
import lombok.Getter;

/**
 * <p>Entity representing User Menu.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
@Getter
public class Menu extends Entity {
  private final String label;
  private final String description;
  private final int order;
  private final boolean isVisible;
  private final String link;
  private final Menu[] subsMenus;

  private Menu(
          final MenuBuilder builder
  ) {

    super(builder.getId(), builder.isEnabled(), builder.isDeleted());
    this.label = builder.label;
    this.description = builder.description;
    this.order = builder.order;
    this.isVisible = builder.isVisible;
    this.link = builder.link;
    this.subsMenus = builder.subsMenus;
  }

  public static class MenuBuilder extends AbstractEntityBuilder<Menu> {
    private String label;
    private String description;
    private int order;
    private boolean isVisible;
    private String link;
    private Menu[] subsMenus;

    /**
     * <p>Constructor.</p>
     *
     * @param id      Identifier.
     * @param enabled enabled.
     * @param deleted deleted.
     */
    public MenuBuilder(
            final UUID id,
            final boolean enabled,
            final boolean deleted) {
      super(id, enabled, deleted);
    }

    /**
     * <p>Change label Value.</p>
     *
     * @param label label.
     * @return MenuBuilder
     */
    public MenuBuilder setLabel(final String label) {
      this.label = label;
      return this;
    }

    /**
     * <p>Change Description Value.</p>
     *
     * @param description description.
     * @return MenuBuilder
     */
    public MenuBuilder setDescription(final String description) {
      this.description = description;
      return this;
    }

    /**
     * <p>Change Order Value.</p>
     *
     * @param order order.
     * @return MenuBuilder
     */
    public MenuBuilder setOrder(final int order) {
      this.order = order;
      return this;
    }

    /**
     * <p>Change Visibility Value.</p>
     *
     * @param isVisible visibility.
     * @return MenuBuilder
     */
    public MenuBuilder setIsVisible(final boolean isVisible) {
      this.isVisible = isVisible;
      return this;
    }

    /**
     * <p>Change Link Value.</p>
     *
     * @param link link.
     * @return MenuBuilder
     */
    public MenuBuilder setLink(final String link) {
      this.link = link;
      return this;
    }

    /**
     * <p>Change subMenus Value.</p>
     *
     * @param subsMenus sub menus.
     * @return MenuBuilder
     */
    public MenuBuilder setSubMenus(final Menu[] subsMenus) {
      this.subsMenus = subsMenus;
      return this;
    }

    /**
     * <p>Build new Menu.</p>
     *
     * @return Menu.
     */
    @Override
    public Menu buildEntity() {
      return new Menu(this);
    }
  }
}