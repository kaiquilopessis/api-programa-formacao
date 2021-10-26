package br.com.sis.rh.apiprogramaformacao.api.mock;

import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class MockDatasource extends ArrayList {

    private ArrayList<MockData> listaDeInstrutores = new ArrayList<>();
    private ArrayList<MockData> listaDeParticipantes = new ArrayList<>();

    public MockDatasource(){
        MockData inst1 = new MockData();
        inst1.setNome("Kaiqui Lopes");
        inst1.setCpf("12312312312");
        inst1.setEmail("kaiquilopes@sisconsultoria.com.br");
        inst1.setTelefone("14999998888");
        inst1.setCargo("Analista Java Sr");

        MockData inst2 = new MockData();
        inst2.setNome("Luciana Neuber");
        inst2.setCpf("23423423434");
        inst2.setEmail("luciananeuber@sisconsultoria.com.br");
        inst2.setTelefone("11999998888");
        inst2.setCargo("Consultora de RH");

        MockData inst3 = new MockData();
        inst3.setNome("Nico Steppat");
        inst3.setCpf("45645645678");
        inst3.setEmail("nicosteppat@alura.com.br");
        inst3.setTelefone("21999998888");
        inst3.setCargo("Desenvolvedor");

        MockData part1 = new MockData();
        part1.setNome("Iago Baldani");
        part1.setCpf("90987876545");
        part1.setEmail("iagoalmeida@sisconsultoria.com.br");
        part1.setTelefone("14999998888");
        part1.setCargo("Trainee");

        MockData part2 = new MockData();
        part2.setNome("Felipe Salmazo");
        part2.setCpf("78643210987");
        part2.setEmail("felipesalmazo@sisconsultoria.com.br");
        part2.setTelefone("14999998888");
        part2.setCargo("Estagiário");

        MockData part3 = new MockData();
        part3.setNome("Letícia Angulo");
        part3.setCpf("87976556789");
        part3.setEmail("leticiaangulo@sisconsultoria.com.br");
        part3.setTelefone("12999998888");
        part3.setCargo("Estagiário");

        this.listaDeInstrutores.add(inst1);
        this.listaDeInstrutores.add(inst2);
        this.listaDeInstrutores.add(inst3);

        this.listaDeParticipantes.add(part1);
        this.listaDeParticipantes.add(part2);
        this.listaDeParticipantes.add(part3);
    }

    public MockData getInstrutorPorCpf(String cpf) throws NotFoundException {
       for(int i = 0; i<listaDeInstrutores.size(); i++){
           MockData instrutor = listaDeInstrutores.get(i);

           if(instrutor.getCpf().equals(cpf)){
               return instrutor;
           }
       }

       throw new NotFoundException("Não há nenhum instrutor com o CPF informado");
    }

    public MockData getParticipantePorCpf(String cpf) throws NotFoundException {
        for(int i = 0; i<listaDeParticipantes.size(); i++){
            MockData participante = listaDeParticipantes.get(i);

            if(participante.getCpf().equals(cpf)){
                return participante;
            }
        }

        throw new NotFoundException("Não há nenhum participante com o CPF informado");
    }

    public List<MockData> getListaDeInstrutores() {
        return listaDeInstrutores;
    }

    public List<MockData> getListaDeParticipantes() {
        return listaDeParticipantes;
    }
}
