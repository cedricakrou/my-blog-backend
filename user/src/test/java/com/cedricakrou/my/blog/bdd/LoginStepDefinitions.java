package com.cedricakrou.my.blog.bdd;

import com.cedricakrou.my.blog.tdd.user.facade.UserFacadeImpl;
import com.cedricakrou.my.blog.user.application.commands.LoginCommand;
import com.cedricakrou.my.blog.user.application.facade.UserFacade;
import com.cedricakrou.my.blog.user.application.repositories.UserRepository;
import com.cedricakrou.my.blog.user.application.usecases.LoginUseCase;
import com.cedricakrou.my.blog.user.domain.entities.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Optional;
import org.junit.Assert;
import org.mockito.Mockito;

/**
 * @author KAKOU Akrou Cedric 2023-02-15
 */
public class LoginStepDefinitions {

  LoginCommand loginCommand;
  LoginUseCase loginUseCase;
  UserFacade userFacade;
  UserRepository userRepository;

  @Given("I have a user registered.")
  public void i_have_a_user_registered() {

    this.loginUseCase = new LoginUseCase(
            this.userFacade
    );

    this.userRepository = Mockito.mock(UserRepository.class);

    this.userFacade = new UserFacadeImpl(this.userRepository);
  }

  @When("I enter {string} and password {string}")
  public void i_enter_and_password(String account, String password) {

    loginCommand = new LoginCommand(
            account,
            password
    );

    loginUseCase.perform(loginCommand);
  }

  @Then("I {string} will be logged in.")
  public void i_will_be_logged_in(String account) {

    Optional<User> optionalUser = this.userFacade.findUserByEmail(account);

    Assert.assertTrue(optionalUser.isPresent());

    User user = optionalUser.get();
    Assert.assertTrue(user.isLoggedIn());
  }
}
