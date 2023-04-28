package br.com.meli.estudos.service;

import br.com.meli.estudos.dto.CepDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
@Service
public class CepServiceImpl implements CepService{

    @Override
    public CepDto findCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<CepDto> resp = restTemplate
                    .getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), CepDto.class);
        }catch (Exception e){
           throw new ResourceAccessException("Cep invalido");
        }
        //return resp.getBody();
        return null;
    }
}


