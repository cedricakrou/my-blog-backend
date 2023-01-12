package com.cedricakrou.my.blog.adapter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Swagger configuration.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * <p>Swagger configuration.</p>
   *
   * @return Swagger configuration.
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
  }
}
