package br.com.meli.estudos.controller;
import br.com.meli.estudos.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;


@RestController
@RequestMapping("/buscacep")
public class CepController {
    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<?> findCep(@PathVariable("cep")String cep){
       try {
           return new ResponseEntity<>(cepService.findCep(cep), HttpStatus.OK);
       } catch(Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
    }
}

