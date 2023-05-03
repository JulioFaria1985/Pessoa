package br.com.meli.estudos.service;

import br.com.meli.estudos.dto.PessoaDto;
import br.com.meli.estudos.dto.PessoaDtoOut;

import java.io.IOException;
import java.util.List;
//
public interface PessoaService {
    PessoaDtoOut findById(Long id);

    List<PessoaDtoOut> findAll();

    PessoaDto create(PessoaDto pessoaDto);

    PessoaDto update(PessoaDto pessoaDto);

   void deleteById(Long id);






}
