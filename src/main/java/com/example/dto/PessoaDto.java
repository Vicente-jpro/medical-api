package com.example.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaDto {
	
	private Integer idPessoa;
	private String nome;
	private String bi;
	private List<ContactoDto> contactos;

}
