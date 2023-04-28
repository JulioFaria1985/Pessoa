package br.com.meli.estudos.service;
import br.com.meli.estudos.dto.PessoaDto;
import br.com.meli.estudos.dto.PessoaDtoOut;
import br.com.meli.estudos.entity.Pessoa;
import br.com.meli.estudos.exceptions.ResourceNotFoundException;
import br.com.meli.estudos.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PessoaServiceImpl implements PessoaService{
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ModelMapper modelMapper;




    @Override
    public PessoaDto create(PessoaDto pessoaDto) {
        Pessoa pessoaexiste = pessoaRepository.findByCpf(pessoaDto.getCpf());
        if (pessoaexiste!=null){
            throw new ResourceAccessException("Usuario ja existe");
        }
        Pessoa pessoa = modelMapper.map(pessoaDto,Pessoa.class);

        pessoa = pessoaRepository.save(pessoa);

        return modelMapper.map(pessoa , PessoaDto.class);
    }




    @Override
    public List<PessoaDtoOut> findAll() {
        List<Pessoa> entities = pessoaRepository.findAll();

        return entities.stream().map(e -> new PessoaDtoOut(e.getUser(), e.getNome()))
                .collect(Collectors.toList());

    }



    @Override
    public PessoaDto update(PessoaDto pessoaDto) {
        return null;
    }
    @Override
    public PessoaDtoOut findById(Long id){
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Essa pessoa não existe"));
        PessoaDtoOut returnDto = new PessoaDtoOut(entity.getUser(), entity.getNome());
        return returnDto;
    }
    @Override
    public void deleteById(Long id) {
        Pessoa entity= pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa nao  encontrado"));
        pessoaRepository.delete(entity);
    }


    }


