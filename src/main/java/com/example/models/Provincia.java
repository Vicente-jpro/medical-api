package com.example.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany( mappedBy = "provincia")
	private List<Municipio> municipios;
	
}
