package com.cedricakrou.my.blog.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author KAKOU Akrou Cedric 2023-02-15
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:com.cedricakrou.my.blog.bdd"}
)
public class LoginTest {
}
