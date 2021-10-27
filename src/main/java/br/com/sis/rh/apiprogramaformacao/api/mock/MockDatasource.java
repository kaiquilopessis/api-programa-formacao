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
        inst1.setCpf("12345678910");
        inst1.setEmail("kaiquilopes@sisconsultoria.com.br");
        inst1.setTelefone("14999998888");
        inst1.setCargo("Analista Java Sr");

        MockData inst2 = new MockData();
        inst2.setNome("Luciana Neuber");
        inst2.setCpf("90980870732");
        inst2.setEmail("luciananeuber@sisconsultoria.com.br");
        inst2.setTelefone("11999998888");
        inst2.setCargo("Consultora de RH");

        MockData inst3 = new MockData();
        inst3.setNome("Nico Steppat");
        inst3.setCpf("56778906375");
        inst3.setEmail("nicosteppat@alura.com.br");
        inst3.setTelefone("21999998888");
        inst3.setCargo("Desenvolvedor");

        MockData part1 = new MockData();
        part1.setNome("Iago Baldani");
        part1.setCpf("000000001");
        part1.setEmail("iagoalmeida@sisconsultoria.com.br");
        part1.setTelefone("14999998888");
        part1.setCargo("Estagiário");

        MockData part2 = new MockData();
        part2.setNome("Felipe Salmazo");
        part2.setCpf("000000002");
        part2.setEmail("felipesalmazo@sisconsultoria.com.br");
        part2.setTelefone("14999998888");
        part2.setCargo("Estagiário");

        MockData part3 = new MockData();
        part3.setNome("Letícia Angulo");
        part3.setCpf("0101012020");
        part3.setEmail("leticiaangulo@sisconsultoria.com.br");
        part3.setTelefone("12999998888");
        part3.setCargo("Estagiário");

        MockData part4 = new MockData();
        part4.setNome("Teste");
        part4.setCpf("12121212");
        part4.setEmail("teste@sisconsultoria.com.br");
        part4.setTelefone("12999998888");
        part4.setCargo("Estagiário");

        MockData part5 = new MockData();
        part5.setNome("Teste");
        part5.setCpf("22456832698");
        part5.setEmail("teste@sisconsultoria.com.br");
        part5.setTelefone("12999998888");
        part5.setCargo("Estagiário");

        MockData part6 = new MockData();
        part6.setNome("Teste");
        part6.setCpf("22485248946");
        part6.setEmail("teste@sisconsultoria.com.br");
        part6.setTelefone("12999998888");
        part6.setCargo("Estagiário");

        MockData part7 = new MockData();
        part7.setNome("Teste");
        part7.setCpf("428000000");
        part7.setEmail("teste@sisconsultoria.com.br");
        part7.setTelefone("12999998888");
        part7.setCargo("Estagiário");

        MockData part8 = new MockData();
        part8.setNome("Teste");
        part8.setCpf("77435635467");
        part8.setEmail("teste@sisconsultoria.com.br");
        part8.setTelefone("12999998888");
        part8.setCargo("Estagiário");

        MockData part9 = new MockData();
        part9.setNome("Teste 9");
        part9.setCpf("98767856798");
        part9.setEmail("teste@sisconsultoria.com.br");
        part9.setTelefone("12999998888");
        part9.setCargo("Estagiário");

        MockData part10 = new MockData();
        part9.setNome("Teste 10");
        part9.setCpf("43254397818");
        part9.setEmail("teste@sisconsultoria.com.br");
        part9.setTelefone("12999998888");
        part9.setCargo("Trainee");

        this.listaDeInstrutores.add(inst1);
        this.listaDeInstrutores.add(inst2);
        this.listaDeInstrutores.add(inst3);

        this.listaDeParticipantes.add(part1);
        this.listaDeParticipantes.add(part2);
        this.listaDeParticipantes.add(part3);
        this.listaDeParticipantes.add(part4);
        this.listaDeParticipantes.add(part5);
        this.listaDeParticipantes.add(part6);
        this.listaDeParticipantes.add(part7);
        this.listaDeParticipantes.add(part8);
    }

    public MockData getInstrutorPorCpf(String cpf) {
       for(int i = 0; i<listaDeInstrutores.size(); i++){
           MockData instrutor = listaDeInstrutores.get(i);

           if(instrutor.getCpf().equals(cpf)){
               return instrutor;
           }
       }
       return null;
    }

    public MockData getParticipantePorCpf(String cpf) {
        for(int i = 0; i<listaDeParticipantes.size(); i++){
            MockData participante = listaDeParticipantes.get(i);

            if(participante.getCpf().equals(cpf)){
                return participante;
            }
        }
        return null;
    }

    public List<MockData> getListaDeInstrutores() {
        return listaDeInstrutores;
    }

    public List<MockData> getListaDeParticipantes() {
        return listaDeParticipantes;
    }
}
