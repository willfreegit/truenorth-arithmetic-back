package com.truenorth.arithmetic.models.request;

import lombok.Data;

import java.util.Set;

import javax.validation.constraints.*;

/**
 * Singup request pojo
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Data
public class SignupRequest {
  @NotBlank
  @Size(min = 6, max = 50)
  private String username;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

}
