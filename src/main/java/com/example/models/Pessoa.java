package com.example.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table( name = "pessoas")
public class Pessoa {

	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "id")
	private Integer idPessoa;
	
	@Column( name = "nome" )
	private String nome;
	
	@Column( name = "bi")
	private String bi;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoa")
	private List<Contacto> contactos;
}
