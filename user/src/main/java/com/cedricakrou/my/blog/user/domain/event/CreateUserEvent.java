package com.cedricakrou.my.blog.user.domain.event;

import com.cedricakrou.library.generic.event.EventManager;
import com.cedricakrou.my.blog.user.application.playload.CreateUserEventPayload;

/**
 * <p>Event send after the creating of user.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-26
 */
public interface CreateUserEvent extends EventManager<CreateUserEventPayload> {
}
