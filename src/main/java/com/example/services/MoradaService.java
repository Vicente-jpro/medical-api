package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Morada;
import com.example.repository.MoradaRepository;

@Service
public class MoradaService {

    @Autowired
    private MoradaRepository moradaRepository;

    public Morada salvar(Morada morada) {
        return this.moradaRepository.save(morada);
    }

}
