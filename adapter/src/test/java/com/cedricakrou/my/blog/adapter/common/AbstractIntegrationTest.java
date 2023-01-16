package com.cedricakrou.my.blog.adapter.common;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * <p>Abstract class which contains all container images.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-16
 */
public abstract class AbstractIntegrationTest {

  private static final PostgreSQLContainer<?> POSTGRES_SQL_CONTAINER;

  static {
    POSTGRES_SQL_CONTAINER = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:14.2-alpine")
    );

    POSTGRES_SQL_CONTAINER.start();
  }

  /**
   * <p>Test containers Dynamic properties.</p>
   *
   * @param dynamicPropertyRegistry Dynamic property registry.
   */
  @DynamicPropertySource
  static void testContainersProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
    dynamicPropertyRegistry.add("spring.datasource.url", POSTGRES_SQL_CONTAINER::getJdbcUrl);
    dynamicPropertyRegistry.add("spring.datasource.username", POSTGRES_SQL_CONTAINER::getUsername);
    dynamicPropertyRegistry.add("spring.datasource.password", POSTGRES_SQL_CONTAINER::getPassword);
  }
}
