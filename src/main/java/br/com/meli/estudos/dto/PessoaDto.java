package br.com.meli.estudos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    private Long id;
    private String nome;
    private String cpf;
    private String user;
    private String senha;

}
