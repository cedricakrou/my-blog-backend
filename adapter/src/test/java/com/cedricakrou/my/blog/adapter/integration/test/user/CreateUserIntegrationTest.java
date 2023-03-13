package com.cedricakrou.my.blog.adapter.integration.test.user;

import com.cedricakrou.my.blog.adapter.common.AbstractIntegrationTest;
import com.cedricakrou.my.blog.adapter.user.primaries.rest.form.CreateUserForm;
import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.domain.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * <p>Integration Test for creating new User.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-24
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CreateUserIntegrationTest extends AbstractIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  UserRepository userRepository;

  @Test
  void createUser_shouldFailedWhenEmailIsEmpty() throws Exception {

    String email = "";
    String username = "test";

    CreateUserForm form = new CreateUserForm(
            email,
            username
    );

    mockMvc.perform(
                    MockMvcRequestBuilders.post("/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  void createUser_shouldFailedWhenEmailIsInvalid() throws Exception {

    String email = "cedricakrou";
    String username = "test";

    CreateUserForm form = new CreateUserForm(
            email,
            username
    );

    mockMvc.perform(
                    MockMvcRequestBuilders.post("/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  void createUser_shouldFailedWhenUsernameIsEmpty() throws Exception {

    String email = "cedricakrou@gmail.com";
    String username = "";

    CreateUserForm form = new CreateUserForm(
            email,
            username
    );

    mockMvc.perform(
                    MockMvcRequestBuilders.post("/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  void createUser_shouldFailedWhenUsernameSizeIsLesserThan3() throws Exception {

    String email = "cedricakrou@gmail.com";
    String username = "te";

    CreateUserForm form = new CreateUserForm(
            email,
            username
    );

    mockMvc.perform(
                    MockMvcRequestBuilders.post("/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  @DisplayName("Create User")
  void createUser_shouldSucceed() throws Exception {

    String email = "cedricakrou@gmail.com";
    String username = "cedricakrou";

    CreateUserForm form = new CreateUserForm(
            email,
            username
    );

    mockMvc.perform(
                    MockMvcRequestBuilders.post("/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  void createUser_shouldFailedWhenUsernameAlreadyOrUsername() throws Exception {

    // Given
    String email = "cedricakrou@gmail.com";
    String username = "cedricakrou";

    User user = new User
            .UserBuilder(UUID.randomUUID(), true, false)
            .setUsername(username)
            .setEmail(email)
            .buildEntity();

    this.userRepository.save(user);

    CreateUserForm form = new CreateUserForm(
            email,
            username
    );

    // when
    mockMvc.perform(
                    MockMvcRequestBuilders.post("/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(form))
            )
            // Then
            .andExpect(MockMvcResultMatchers.status().isExpectationFailed())
            .andDo(MockMvcResultHandlers.print());
  }

}
