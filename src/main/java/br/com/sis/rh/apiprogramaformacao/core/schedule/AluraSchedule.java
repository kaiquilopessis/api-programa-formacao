package br.com.sis.rh.apiprogramaformacao.core.schedule;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.Alura;
import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.AluraCompare;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ApiAluraDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento.AluraCompareRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ParticipanteRepository;

@Component @EnableScheduling
public class AluraSchedule {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private AluraRepository aluraRepository;

    @Autowired
    private AluraCompareRepository aluraCompareRepository;
    
    @Value("${api-programa-formacao.tokensis.alura}")
    private String tokenSis;

    @Scheduled(cron = "${api-programa-formacao.scheduled.cron}")
    public void aluraSchedule() {

        Integer horasSemana = 0;
        List<Participante> participantes = participanteRepository.findByStatus(StatusAtivo.ATIVO);
        List<String> emailParticipantes = participantes.stream().map(Participante::getEmail)
                .collect(Collectors.toList());
        ApiAluraDto[] registros = this.getAlura();

        for (String email : emailParticipantes) {
            for (ApiAluraDto registro : registros) {
                if (email.compareTo(registro.getEmail()) == 0) {
                    List<AluraCompare> emailsAlura = aluraCompareRepository.findByEmail(registro.getEmail());
                    if (!emailsAlura.isEmpty()) {
                        List<Integer> cursosParticipante = emailsAlura.stream().map(AluraCompare::getIdCurso).collect(Collectors.toList());
                        if (!cursosParticipante.contains(registro.getIdCurso())) {
                            aluraCompareRepository.save(AluraCompare.converter(registro));
                            horasSemana += registro.getCargaHoraria();
                        }
                    }else {
                        aluraCompareRepository.save(AluraCompare.converter(registro));
                        horasSemana += registro.getCargaHoraria();
                    }
                }
            }
            Participante participante = participanteRepository.findByEmail(email);
            Alura alura = new Alura(participante, horasSemana, LocalDate.now(), 30);
            aluraRepository.save(alura);
            horasSemana = 0;
        }
    }

    public ApiAluraDto[] getAlura() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("cursos.alura.com.br")
                .path("corp/api/v1/conclusoes").queryParam("token", tokenSis).build();

        ApiAluraDto[] body = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entity, ApiAluraDto[].class)
                .getBody();
        return body;
    }
}
