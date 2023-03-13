package com.cedricakrou.my.blog.adapter.shared.primaries.rest.controller.advice;

import com.cedricakrou.library.generic.aggregate.application.exception.AlreadyExistsException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <p>Handler for all exceptions thrown in this application.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-12
 */
@ControllerAdvice
public class MyBlogControllerAdviceHandler
        extends ResponseEntityExceptionHandler {

  /**
   * <p>Handler for AlreadyExistsException.</p>
   *
   * @param exception AlreadyExistsException.
   * @return ResponseEntity.
   */
  @ExceptionHandler(AlreadyExistsException.class)
  public ResponseEntity<Object> handleAlreadyExistsException(
          final AlreadyExistsException exception) {

    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", exception.getMessage());

    return new ResponseEntity<>(body, HttpStatus.FOUND);
  }

  /**
   * <p>Handler for ConstraintViolationException.</p>
   *
   * @param exception ConstraintViolationException.
   * @return ResponseEntity.
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Object> handleAlreadyException(
          final ConstraintViolationException exception
  ) {

    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", exception.getMessage());

    return new ResponseEntity<>(body, HttpStatus.EXPECTATION_FAILED);
  }
}
