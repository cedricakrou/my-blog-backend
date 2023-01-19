package com.cedricakrou.my.blog.adapter.integration.test;

import com.cedricakrou.my.blog.adapter.common.AbstractIntegrationTest;
import com.cedricakrou.my.blog.adapter.shared.primary.rest.form.CreateRoleForm;
import com.cedricakrou.my.blog.shared.application.repository.RoleRepository;
import com.cedricakrou.my.blog.shared.domain.entities.Permission;
import com.cedricakrou.my.blog.shared.domain.entities.Role;
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


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author KAKOU Akrou Cedric 2023-01-18
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RoleIntegrationTest extends AbstractIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  RoleRepository roleRepository;

  /**
   * <p>Run before each test.</p>
   */
  @BeforeEach
  void setup() {
    roleRepository.deleteAll();
  }

  /**
   * <p>
   * This test must fail when we want to create Role with an incorrect command element.
   * </p>
   */
  @Test
  void createRole_shouldBeFailedWhenAtLeastOneElementOfCommandIsNotCorrect() throws Exception {

    String roleName = "";
    String description = "";

    CreateRoleForm form = new CreateRoleForm(
            roleName,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/role")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(form)))
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andExpect(MockMvcResultMatchers
                    .jsonPath("$.message")
                    .value("name: Role name is mandatory !"))
            .andDo(MockMvcResultHandlers.print());

  }

  /**
   * <p>
   * This test must be success.
   * </p>
   */
  @Test
  void createRole_shouldBeSucceed() throws Exception {
    String roleName = "ADMIN";
    String description = "";

    CreateRoleForm form = new CreateRoleForm(
            roleName,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/role")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(form)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
  }

  /**
   * <p>
   * This test must fail when Role Name Exists Already.
   * </p>
   */
  @Test
  void createRole_shouldBeFailedWhenRoleNameExistsAlready() throws Exception {

    String roleName = "ADMIN";
    String description = "";

    Role role = new Role(
            UUID.randomUUID(),
            false,
            true,
            roleName,
            description,
            new Permission[]{});

    this.roleRepository.save(role);


    CreateRoleForm form = new CreateRoleForm(
            roleName,
            description
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/role")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(form)))
            .andExpect(MockMvcResultMatchers.status().isFound())
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  void getAllRoles_ShouldBeSucceed() throws Exception {

    String name = "Admin";
    String description = "CIV";

    this.roleRepository.save(new Role(
            UUID.randomUUID(),
            true,
            false,
            name,
            description,
            new Permission[]{}
    ));

    mockMvc.perform(
                    get("/role")
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
