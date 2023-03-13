package com.cedricakrou.my.blog.adapter.configuration.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * <p>Kafka topic configuration.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-26
 */
@Configuration
public class KafkaTopicConfig {

  @Value("${spring.kafka.server.address}")
  private String kafkaAddress;

  /**
   * <p>Kafka admin configuration.</p>
   *
   * @return Kafka Admin.
   */
  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);

    return new KafkaAdmin(configs);
  }
}
