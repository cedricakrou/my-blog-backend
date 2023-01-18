package com.cedricakrou.my.blog.adapter.integration.test;

import com.cedricakrou.my.blog.adapter.common.AbstractIntegrationTest;
import com.cedricakrou.my.blog.shared.application.command.CreateEmploymentTypeCommand;
import com.cedricakrou.my.blog.shared.application.repository.EmploymentTypeRepository;
import com.cedricakrou.my.blog.shared.domain.entities.EmploymentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class EmploymentTypeIntegrationTest extends AbstractIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  EmploymentTypeRepository employmentTypeRepository;

  /**
   * <p>Run before each test.</p>
   */
  @BeforeEach
  void setup() {
    this.employmentTypeRepository.deleteAll();
  }

  /**
   * <p>
   * This test must fail when we want to create Permission with an incorrect command element.
   * </p>
   */
  @Test
  void createPermission_shouldBeFailedWhenAtLeastOneElementOfCommandIsNotCorrect() throws Exception {

    String name = "";
    String description = "";

    CreateEmploymentTypeCommand form = new CreateEmploymentTypeCommand(
            name,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/employment-type")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(form)))
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andExpect(MockMvcResultMatchers
                    .jsonPath("$.message")
                    .value("name: Employment type name is mandatory !"))
            .andDo(MockMvcResultHandlers.print());

  }

  /**
   * <p>
   * This test must be success.
   * </p>
   */
  @Test
  void createPermission_shouldBeSucceed() throws Exception {

    String name = "STAGE";
    String description = "";

    CreateEmploymentTypeCommand form = new CreateEmploymentTypeCommand(
            name,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/employment-type")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(form)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
  }

  /**
   * <p>
   * This test must fail when Permission Name Exists Already.
   * </p>
   */
  @Test
  void createPermission_shouldBeFailedWhenRoleNameExistsAlready() throws Exception {

    String name = "READ";
    String description = "";

    EmploymentType permission = new EmploymentType(
            UUID.randomUUID(),
            false,
            true,
            name,
            description);

    this.employmentTypeRepository.save(permission);


    CreateEmploymentTypeCommand form = new CreateEmploymentTypeCommand(
            name,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/employment-type")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(form)))
            .andExpect(MockMvcResultMatchers.status().isFound())
            .andDo(MockMvcResultHandlers.print());
  }
}
