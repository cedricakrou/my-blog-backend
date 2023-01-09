package com.cedricakrou.library.generic.aggregate.domain;

import java.util.UUID;
import lombok.Getter;

/**
 * <p>Class that designates the Entity Builder classes.</p>
 *
 * @param <T> the type of the entity.
 * @author KAKOU Akrou Cedric 2023-01-06
 */
@Getter
public abstract class AbstractEntityBuilder<T extends Entity> {

  private final UUID id;
  private final boolean enabled;
  private final boolean deleted;

  /**
   * <p>Default constructor.</p>
   *
   * @param id      Identifier.
   * @param enabled enabled.
   * @param deleted deleted.
   */
  protected AbstractEntityBuilder(final UUID id,
                                  final boolean enabled,
                                  final boolean deleted) {
    this.id = id;
    this.enabled = enabled;
    this.deleted = deleted;
  }

  /**
   * <p>Build instance of entity.</p>
   *
   * @return entity instance.
   */
  public abstract T buildEntity();
}