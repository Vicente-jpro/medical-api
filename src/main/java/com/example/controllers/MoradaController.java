package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Morada;
import com.example.services.MoradaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/morada")
public class MoradaController {

    @Autowired
    private MoradaService moradaService;

    @PostMapping
    @ApiOperation("Salvar morada.")
    @ApiResponse(code = 201, message = "Morada salva com sucesso.")
    @ResponseStatus(HttpStatus.CREATED)
    public Morada salvar(@RequestBody Morada morada) {
        return this.moradaService.salvar(morada);
    }
}
