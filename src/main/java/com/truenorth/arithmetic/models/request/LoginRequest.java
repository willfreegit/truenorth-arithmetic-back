package com.truenorth.arithmetic.models.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Login request pojo
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Data
public class LoginRequest {
	@NotBlank
  private String username;

	@NotBlank
	private String password;

}
