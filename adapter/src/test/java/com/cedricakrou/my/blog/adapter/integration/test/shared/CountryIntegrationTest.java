package com.cedricakrou.my.blog.adapter.integration.test.shared;

import com.cedricakrou.my.blog.adapter.common.AbstractIntegrationTest;
import com.cedricakrou.my.blog.adapter.shared.primaries.rest.form.CreateCountryForm;
import com.cedricakrou.my.blog.shared.application.repository.CountryRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Country;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * <p>{@link Country} integration tests.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-16
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CountryIntegrationTest extends AbstractIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private CountryRepository countryRepository;

  @BeforeEach
  void cleanUp() {
    this.countryRepository.deleteAll();
  }

  /**
   * <p>
   * Create country should be failed when Formula is not filled correctly.
   * </p>
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

  /**
   * <p>
   * Create a country.
   * </p>
   */
  @Test
  @Order(2)
  void createCountry_ShouldBeSucceed() throws Exception {

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    CreateCountryForm form = new CreateCountryForm(
            countryName,
            countryIsoCode,
            countryIndicative);

    mockMvc.perform(
                    post("/country")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andDo(MockMvcResultHandlers.print());
  }

  /**
   * <p>
   * Create country should be failed when Country name exists already.
   * </p>
   */
  @Test
  @Order(3)
  void createCountry_ShouldBeFailedWhenCountryNameExists() throws Exception {

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    this.countryRepository.save(new Country(
            UUID.randomUUID(),
            true,
            false,
            countryName,
            countryIsoCode,
            countryIndicative
    ));

    CreateCountryForm form = new CreateCountryForm(
            countryName,
            countryIsoCode,
            countryIndicative);

    mockMvc.perform(
                    post("/country")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isFound())
            .andExpect(MockMvcResultMatchers
                    .jsonPath("$.message")
                    .value("Country Already exists with this name !"))
            .andDo(MockMvcResultHandlers.print());
  }

  /**
   * <p>
   * Create country should be failed when Country Iso Code exists already.
   * </p>
   */
  @Test
  @Order(4)
  void createCountry_ShouldBeFailedWhenCountryIsoCodeExists() throws Exception {

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    this.countryRepository.save(new Country(
            UUID.randomUUID(),
            true,
            false,
            countryName,
            countryIsoCode,
            countryIndicative
    ));

    CreateCountryForm form = new CreateCountryForm(
            "Côte d'ivoire",
            countryIsoCode,
            countryIndicative);

    mockMvc.perform(
                    post("/country")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isFound())
            .andExpect(MockMvcResultMatchers
                    .jsonPath("$.message")
                    .value("Country Already exists with this iso code !"))
            .andDo(MockMvcResultHandlers.print());
  }

  /**
   * <p>
   * Create country should be failed when Country Indicative exists already.
   * </p>
   */
  @Test
  @Order(5)
  void createCountry_ShouldBeFailedWhenCountryIndicativeExists() throws Exception {

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    this.countryRepository.save(new Country(
            UUID.randomUUID(),
            true,
            false,
            countryName,
            countryIsoCode,
            countryIndicative
    ));

    CreateCountryForm form = new CreateCountryForm(
            "Côte d'ivoire",
            "CVI",
            countryIndicative);

    mockMvc.perform(
                    post("/country")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isFound())
            .andExpect(MockMvcResultMatchers
                    .jsonPath("$.message")
                    .value("Country Already exists with this indicative !"))
            .andDo(MockMvcResultHandlers.print());
  }

  /**
   * <p>
   * Get all countries.
   * </p>
   */
  @Test
  @Order(6)
  void getAllCountries_ShouldBeSucceed() throws Exception {

    String countryName = "Ivory Coast";
    String countryIsoCode = "CIV";
    int countryIndicative = 225;

    this.countryRepository.save(new Country(
            UUID.randomUUID(),
            true,
            false,
            countryName,
            countryIsoCode,
            countryIndicative
    ));

    mockMvc.perform(
                    get("/country")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers
                    .jsonPath("$.length()")
                    .value(1))
            .andDo(MockMvcResultHandlers.print());
  }
}
