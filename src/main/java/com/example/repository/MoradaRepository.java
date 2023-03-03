package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Morada;

@Repository
public interface MoradaRepository extends JpaRepository<Morada, Integer> {

}
