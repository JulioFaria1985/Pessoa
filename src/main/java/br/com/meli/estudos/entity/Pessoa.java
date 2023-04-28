package br.com.meli.estudos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String nome;
    private String cpf;
    private String user;
    private String senha;

}
