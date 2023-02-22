package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "contactos")
public class Contacto {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "id")
	private Integer idContacto;
	
	@Column( name = "telemovel", length = 17)
	private String telemovel;
	
	@Column( name = "whatsapp", length = 17)
	private String whatsapp;
	
	@Column( name = "email", length = 30)
	private String email;

}
