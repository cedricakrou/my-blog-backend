package com.cedricakrou.my.blog.adapter;

import com.cedricakrou.library.UtilityClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Starting class.</p>
 *
 * @author KAKOU AKrou Cedric
 */
@SpringBootApplication
public class AdapterApplication extends UtilityClass {

  /**
   * <p>Default constructor.</p>
   */
  private AdapterApplication() {
    super();
  }

  /**
   * <p>Starting method.</p>
   *
   * @param args arguments table.
   */
  public static void main(final String[] args) {
    SpringApplication.run(AdapterApplication.class, args);
  }
}
