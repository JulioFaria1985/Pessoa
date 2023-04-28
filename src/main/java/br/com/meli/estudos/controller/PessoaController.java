package br.com.meli.estudos.controller;

import br.com.meli.estudos.dto.PessoaDto;
import br.com.meli.estudos.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    private ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PessoaDto pessoaDto) {
        try {
            return new ResponseEntity<>(pessoaService.create(pessoaDto), HttpStatus.CREATED);
        }
        catch(ResourceAccessException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(pessoaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(pessoaService.findById(id), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PessoaDto pessoa) {
        pessoa.setId(id);
        PessoaDto returnPessoa = pessoaService.update(pessoa);
        return ResponseEntity.ok(returnPessoa);

    }



}
