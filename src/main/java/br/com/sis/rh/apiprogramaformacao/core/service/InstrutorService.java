package br.com.sis.rh.apiprogramaformacao.core.service;


import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {

    @Autowired
    InstrutorRepository instrutorRepository;

    public List<Instrutor> todosInstrutores(){
        return instrutorRepository.findAll();
    }

    public Instrutor buscaPorCpf(String id){
        Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(id);

        return optionalInstrutor.get();
    }

    public void salva(Instrutor instrutor){
        instrutorRepository.save(instrutor);
    }


}
