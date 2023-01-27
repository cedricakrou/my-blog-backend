package com.cedricakrou.my.blog.adapter.configuration.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * <p>Kafka producer config.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-26
 */
@Configuration
class KafkaProducerConfig {

  @Value("${spring.kafka.server.address}")
  private String kafkaAddress;

  /**
   * <p>Producer factory configuration.</p>
   *
   * @return default producer factory configuration.
   */
  @Bean
  public ProducerFactory<String, String> producerFactory() {

    Map<String, Object> configProperties = new HashMap<>();
    configProperties.put(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
            this.kafkaAddress);
    configProperties.put(
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
            StringSerializer.class);
    configProperties.put(
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
            StringSerializer.class);

    return new DefaultKafkaProducerFactory(configProperties);
  }

  /**
   * <p>Kafka template configuration.</p>
   *
   * @return kafka template configuration.
   */
  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}
