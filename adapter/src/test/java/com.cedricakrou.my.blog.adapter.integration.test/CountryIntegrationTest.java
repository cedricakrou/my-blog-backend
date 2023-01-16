package com.cedricakrou.my.blog.adapter.integration.test;

import com.cedricakrou.my.blog.adapter.common.AbstractIntegrationTest;
import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreateCountryForm;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * <p>{@link Country} integration tests.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-16
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CountryIntegrationTest extends AbstractIntegrationTest {

  @Autowired
  MockMvc mockMvc;


  /**
   * <
   */
  @Test
  @Order(1)
  void createCountry_ShouldBeFailedWhenAtlLeastElementOfFormDataIsEmpty() throws Exception {

    CreateCountryForm form = new CreateCountryForm("", "", 0);

    mockMvc.perform(
                    post("/country")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed());
  }
}
