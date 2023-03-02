package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table( name = "Municipios")
public class Municipio {

	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "id")
	private Integer idMunicipio;
	
	@Column( name = "nome_municipio")
	private String nomeMunicipio;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn( name = "provincia_id")
	private Provincia provincia;
}
