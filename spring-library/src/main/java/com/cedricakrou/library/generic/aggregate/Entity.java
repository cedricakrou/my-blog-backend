package com.cedricakrou.library.generic.aggregate;

import java.util.UUID;
import lombok.Getter;

/**
 * <p>Class that designates the Entity classes.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
@Getter
public class Entity extends CommonProperties {
  private final UUID id;

  /**
   * <p>Constructor.</p>
   *
   * @param id      Id.
   * @param enabled Enabled
   * @param deleted Deleted.
   */
  public Entity(final UUID id, final boolean enabled, final boolean deleted) {
    super(enabled, deleted);
    this.id = id;
  }
}
