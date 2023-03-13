package com.cedricakrou.my.blog.bdd.step.definitions;

import com.cedricakrou.my.blog.tdd.user.facade.UserFacadeImpl;
import com.cedricakrou.my.blog.tdd.user.repositories.UserRepositoryStub;
import com.cedricakrou.my.blog.user.application.commands.LoginCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.application.usecases.LoginUseCase;
import com.cedricakrou.my.blog.user.domain.entities.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;

/**
 * <p>Login Feature Step Definitions.</p>
 *
 * @author KAKOU Akrou Cedric 2023-02-15
 */
public class LoginStepDefinitions {


  LoginCommand loginCommand;
  LoginUseCase loginUseCase;
  UserFacade userFacade;
  UserRepository userRepository;

  public LoginStepDefinitions() {

    this.userRepository = new UserRepositoryStub();

    this.userFacade = new UserFacadeImpl(this.userRepository);

    this.loginUseCase = new LoginUseCase(
            this.userFacade
    );
  }

  @Given("the following users exists:")
  public void the_following_users_exists(List<Map<String, String>> dataTable) {

    for (Map<String, String> data : dataTable) {

      String firstname = data.get("firstname");
      String lastname = data.get("lastname");
      String email = data.get("email");
      String username = data.get("username");
      String password = data.get("password");

      User user = new User.UserBuilder(
              UUID.randomUUID(),
              true,
              false)
              .setFirstname(firstname)
              .setLastname(lastname)
              .setEmail(email)
              .setUsername(username)
              .setPassword(password)
              .buildEntity();

      this.userFacade.saveUser(user);
    }
  }

  @When("I enter {string} and password {string}")
  public void i_enter_and_password(String username, String password) {

    this.loginCommand = new LoginCommand(
            username,
            password
    );

    this.loginUseCase.perform(loginCommand);
  }

  @Then("I {string} can't be logged.")
  public void i_can_t_be_logged(String username) {

    Optional<User> optionalUser = this.userFacade.findUserByUsername(username);

    Assertions.assertTrue(optionalUser.isPresent());
    Assertions.assertTrue(optionalUser.get().isLoggedIn());
  }
}

