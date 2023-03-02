package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Municipio;
import com.example.models.Provincia;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{
	
	List<Municipio> findByProvincia(Provincia provincia);

}
