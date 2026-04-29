package com.topcarservice.coreapi.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AutorizacaoDTO {
	
	@Email
	@NotBlank
	private String login;	
	
	@NotBlank
	private String senha;

}
