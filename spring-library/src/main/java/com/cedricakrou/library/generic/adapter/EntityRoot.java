package com.cedricakrou.library.generic.adapter;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * <p>Entity root.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
@Getter
@MappedSuperclass
public abstract class EntityRoot {

  @Id
  @Column(name = "id")
  private UUID id;
  @Column(name = "is_enabled")
  private boolean enabled;
  @Column(name = "is_deleted")
  private boolean deleted;

  /**
   * <p>Secondary constructor.</p>
   *
   * @param id      Identifier.
   * @param enabled Enabled.
   * @param deleted Deleted.
   */
  protected EntityRoot(final UUID id,
                       final boolean enabled,
                       final boolean deleted) {
    this.id = id;
    this.enabled = enabled;
    this.deleted = deleted;
  }
}
