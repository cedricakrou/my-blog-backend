package com.cedricakrou.my.blog.user.event;

import com.cedricakrou.library.generic.event.EventManager;
import com.cedricakrou.my.blog.user.application.playload.CreateUserEventPayload;
import com.cedricakrou.my.blog.user.domain.event.CreateUserEvent;

/**
 * <p>Implementation of {@link EventManager}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-26
 */
public class CreateUserEventImpl implements CreateUserEvent {

  @Override
  public void publish(CreateUserEventPayload payload) {
  }
}
