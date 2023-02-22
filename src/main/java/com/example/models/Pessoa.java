package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

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
	@ManyToOne
	@JoinColumn( name = "contacto_id")
	private Contacto contacto;
}
