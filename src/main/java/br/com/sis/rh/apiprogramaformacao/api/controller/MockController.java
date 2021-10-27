package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.mock.MockData;
import br.com.sis.rh.apiprogramaformacao.api.mock.MockDatasource;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mock")
public class MockController {

    MockDatasource mockDatasource = new MockDatasource();

    @Autowired
    ParticipanteRepository participanteRepository;

    @GetMapping("/instrutor")
    public ResponseEntity<List<MockData>> getListaInstrutor(){
        List<MockData> listaInstrutores = mockDatasource.getListaDeInstrutores();

        return ResponseEntity.ok(listaInstrutores);
    }

    @GetMapping("/instrutor/{cpf}")
    public ResponseEntity getInstrutor(@PathVariable String cpf) throws NotFoundException {
        try{
            MockData instrutor = mockDatasource.getInstrutorPorCpf(cpf);

            return ResponseEntity.ok(instrutor);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    // Retorna a lista de funcionários que não estão inseridos na tabela Participantes da API
    @GetMapping("/participante")
    public ResponseEntity<List<MockData>> getListaParticipante(){
        List<MockData> listaParticipantesMock = mockDatasource.getListaDeParticipantes();
        List<Participante> listaParticipantes = participanteRepository.findAll();

        listaParticipantes.forEach(participante -> {
            for(int i = 0; i < listaParticipantesMock.size(); i++){
                if(participante.getCpf().equals(listaParticipantesMock.get(i).getCpf())){
                    listaParticipantesMock.remove(listaParticipantesMock.get(i));
                    break;
                }
            }
        });

        return ResponseEntity.ok(listaParticipantesMock);
    }

    @GetMapping("/participante/{cpf}")
    public ResponseEntity getParticipante(@PathVariable String cpf) throws NotFoundException {
        try{
            MockData participante = mockDatasource.getParticipantePorCpf(cpf);

            return ResponseEntity.ok(participante);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
