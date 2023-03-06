package com.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MunicipioDto {

    private Integer idMunicipio;
    private String nomeMunicipio;
}