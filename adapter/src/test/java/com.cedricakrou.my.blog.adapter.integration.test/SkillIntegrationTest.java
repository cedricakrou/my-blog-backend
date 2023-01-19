package com.cedricakrou.my.blog.adapter.integration.test;

import com.cedricakrou.my.blog.adapter.common.AbstractIntegrationTest;
import com.cedricakrou.my.blog.shared.application.command.CreateSkillCommand;
import com.cedricakrou.my.blog.shared.application.repository.SkillRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Skill;
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
 * <p>Integration test of Skill</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class SkillIntegrationTest extends AbstractIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  SkillRepository skillRepository;

  /**
   * <p>Run before each test.</p>
   */
  @BeforeEach
  void setup() {
    this.skillRepository.deleteAll();
  }

  /**
   * <p>
   * This test must fail when we want to create Permission with an incorrect command element.
   * </p>
   */
  @Test
  void createSkill_shouldBeFailedWhenAtLeastOneElementOfCommandIsNotCorrect() throws Exception {

    String name = "";
    String description = "";

    CreateSkillCommand form = new CreateSkillCommand(
            name,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/skill")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(form)))
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andExpect(MockMvcResultMatchers
                    .jsonPath("$.message")
                    .value("name: Skill name is mandatory !"))
            .andDo(MockMvcResultHandlers.print());

  }

  /**
   * <p>
   * This test must be success.
   * </p>
   */
  @Test
  void createSkill_shouldBeSucceed() throws Exception {
    String name = "READ";
    String description = "";

    CreateSkillCommand form = new CreateSkillCommand(
            name,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/skill")
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
  void createSkill_shouldBeFailedWhenRoleNameExistsAlready() throws Exception {

    String name = "READ";
    String description = "";

    Skill skill = new Skill(
            UUID.randomUUID(),
            false,
            true,
            name,
            description);

    this.skillRepository.save(skill);


    CreateSkillCommand form = new CreateSkillCommand(
            name,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/skill")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(form)))
            .andExpect(MockMvcResultMatchers.status().isFound())
            .andDo(MockMvcResultHandlers.print());
  }
}
