package com.cedricakrou.library.generic.aggregate.application;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * <p>Scope for all command of Use Cases.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-09
 */
public interface Command {

  /**
   * <p>check if all constraints of validator
   * are respected or else thrown exception.</p>
   */
  default void checkValidity() {
    ValidatorFactory validatorFactory =
            Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();
    Set<ConstraintViolation<Command>> validate =
            validator.validate(this, new Class[0]);
    if (!validate.isEmpty()) {
      throw new ConstraintViolationException(validate);
    }
  }
}
