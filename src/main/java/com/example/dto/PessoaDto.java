package com.example.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.models.Contacto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaDto {
	
	private Integer idPessoa;
	private String nome;
	private String bi;

	private Contacto contacto;

}
