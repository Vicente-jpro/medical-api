package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table( name = "Provincias")
public class Provincia {
	
	@Id @GeneratedValue( strategy =  GenerationType.AUTO)
	@Column( name = "id")
	private Integer idProvincia;
	
	@Column( name = "nome_provincia")
	private String nomeProvicia;
	
}
