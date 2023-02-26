package com.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactoDto {

	private Integer idContacto;
	private String telemovel;
	private String whatsapp;
	private String email;
}
