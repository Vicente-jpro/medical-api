package com.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoradaDto extends MunicipioDto {

    private Integer idMorada;
    private String descricao;

}
