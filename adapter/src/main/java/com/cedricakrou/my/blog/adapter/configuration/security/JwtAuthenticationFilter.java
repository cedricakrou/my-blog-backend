package com.cedricakrou.my.blog.adapter.configuration.security;

import com.cedricakrou.library.security.jwt.JwtAuthentication;
import com.cedricakrou.library.security.jwt.JwtAuthenticationImpl;
import com.cedricakrou.library.security.jwt.JwtVerificationResponse;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * <p>Jwt Authentication Filter.</p>
 *
 * @author KAKOU Akrou Cedric 2023-04-11
 */
@Component
final class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtAuthentication jwtAuthentication;

  @Value("${cedricakrou.my-blog.jwt.secret-key}")
  private String jwtSecretKey;

  private JwtAuthenticationFilter() {
    this.jwtAuthentication = new JwtAuthenticationImpl();
  }

  @Override
  protected void doFilterInternal(final HttpServletRequest request,
                                  final HttpServletResponse response,
                                  final FilterChain filterChain)
          throws ServletException, IOException {

    if (!hasAuthorizationBearer(request)) {
      filterChain.doFilter(request, response);
      return;
    }

    String jwtToken = getToken(request);

    JwtVerificationResponse jwtVerificationResponse = jwtAuthentication
            .tokenIsValid(jwtToken, jwtSecretKey);


    if (!jwtVerificationResponse.isStatus()) {
      filterChain.doFilter(request, response);
      return;
    }

    String username = jwtAuthentication.getUsername(jwtToken, jwtSecretKey);

    UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    null);

    authenticationToken
            .setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

    SecurityContextHolder
            .getContext()
            .setAuthentication(authenticationToken);
  }

  private boolean hasAuthorizationBearer(
          final HttpServletRequest request) {

    String header = request.getHeader("Authorization");
    if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
      return false;
    }

    return true;
  }

  private String getToken(final HttpServletRequest request) {

    String header = request.getHeader("Authorization");

    return header.split(" ")[1];
  }


}
