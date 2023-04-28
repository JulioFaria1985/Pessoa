package br.com.meli.estudos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CepDtoOut {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
