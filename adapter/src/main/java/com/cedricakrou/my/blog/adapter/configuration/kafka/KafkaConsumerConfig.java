package com.cedricakrou.my.blog.adapter.configuration.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

/**
 * <p>Kafka consumer configuration.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-26
 */
@EnableKafka
@Configuration
class KafkaConsumerConfig {

  @Value("${spring.kafka.server.address}")
  private String kafkaAddress;

  @Value("${spring.kafka.server.group.id}")
  private String groupId;

  /**
   * <p>Consumer factory configuration.</p>
   *
   * @return Kafka Consumer Factory.
   */
  @Bean
  public ConsumerFactory<String, String> consumerFactory() {

    Map<String, Object> configs =
            new HashMap<>();
    configs.put(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
            this.kafkaAddress);
    configs.put(
            ConsumerConfig.GROUP_ID_CONFIG,
            this.groupId);
    configs.put(
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class);
    configs.put(
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class);


    return new DefaultKafkaConsumerFactory(configs);
  }

  /**
   * <p>Kafka Listener container Factory configuration.</p>
   *
   * @return kafkaListenerContainerFactory
   **/
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String>
  kafkaListenerContainerFactory() {

    ConcurrentKafkaListenerContainerFactory<String, String> factory =
            new ConcurrentKafkaListenerContainerFactory<>();

    factory.setConsumerFactory(consumerFactory());

    return factory;
  }
}
