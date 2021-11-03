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
    private InstrutorRepository repository;

    public List<Instrutor> todosInstrutores(){
        return repository.findAll();
    }

    public Instrutor buscaPorCpf(String id){
        Optional<Instrutor> optionalInstrutor = repository.findById(id);

        return optionalInstrutor.get();
    }

    public List<Instrutor> buscaPorStatus(String status){
        List<Instrutor> listInstrutor = repository.findByStatus(status);

        return listInstrutor;
    }

    public void salva(Instrutor instrutor){
        repository.save(instrutor);
    }

    //Métodos criados por Marco Aguiar

}
