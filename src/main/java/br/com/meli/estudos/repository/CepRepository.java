package br.com.meli.estudos.repository;

import br.com.meli.estudos.entity.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository <Cep,String> {

}
