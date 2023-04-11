package com.cedricakrou.my.blog.adapter.configuration.security;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * <p>Web Security configuration.</p>
 *
 * @author KAKOU Akrou Cedric 2023-04-11
 */
@Configuration
public class WebSecurityConfig {

  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  /**
   * <p>Web security configuration constructor.</p>
   *
   * @param jwtAuthenticationFilter jwt token filter.
   */
  public WebSecurityConfig(
          final JwtAuthenticationFilter jwtAuthenticationFilter) {
    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
  }

  /**
   * <p>Security Filter chain.</p>
   *
   * @param http http security configuration.
   * @return security filter chain.
   * @throws Exception exception
   */
  @Bean
  public SecurityFilterChain securityFilterChain(
          final HttpSecurity http) throws Exception {

    http.csrf().disable();

    http.authorizeHttpRequests()
            .antMatchers("/auth/**", "/user/create-account")
            .permitAll()
            .anyRequest()
            .authenticated();

    http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.exceptionHandling().authenticationEntryPoint(
            (request, response, exception) -> response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    exception.getMessage()
            )
    );

    http.addFilterBefore(
            jwtAuthenticationFilter,
            UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
