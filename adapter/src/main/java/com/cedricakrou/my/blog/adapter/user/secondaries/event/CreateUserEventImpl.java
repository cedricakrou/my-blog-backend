package com.cedricakrou.my.blog.adapter.user.secondaries.event;

import com.cedricakrou.my.blog.user.application.playload.CreateUserEventPayload;
import com.cedricakrou.my.blog.user.domain.event.CreateUserEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of {@link CreateUserEvent}.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-26
 */
@Service
class CreateUserEventImpl implements CreateUserEvent {

  private final String createUserTopic = "MY_BLOG_CREATE_USER_TOPIC";

  private final KafkaTemplate<String, String> kafkaTemplate;

  /**
   * <p>Default constructor.</p>
   *
   * @param kafkaTemplate kafka template.
   */
  CreateUserEventImpl(
          final KafkaTemplate<String, String> kafkaTemplate
  ) {
    this.kafkaTemplate = kafkaTemplate;
  }

  /**
   * <p>publish the event.</p>
   *
   * @param payload payload of event.
   */
  @SneakyThrows
  @Override
  public void publish(final CreateUserEventPayload payload) {

    String createUserPayload = new ObjectMapper()
            .writeValueAsString(payload);

    this.kafkaTemplate.send(this.createUserTopic, createUserPayload);
  }
}
