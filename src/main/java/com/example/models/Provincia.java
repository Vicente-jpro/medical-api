package com.example.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@OneToMany( mappedBy = "provincia", fetch = FetchType.LAZY)
	private List<Municipio> municipios;
	
}
