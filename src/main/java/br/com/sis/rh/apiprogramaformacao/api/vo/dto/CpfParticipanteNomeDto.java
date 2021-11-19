package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class CpfParticipanteNomeDto {

    @Id
    @Column(name = "cpf_participante")
    private String cpfParticipante;
    @Column(name = "nome")
    private String nomeCandidato;


    public CpfParticipanteNomeDto(Participante participante){
        this.cpfParticipante = participante.getCpfParticipante();
        this.nomeCandidato = participante.getCandidato().getNome();
    }

    public static List<CpfParticipanteNomeDto> converter(List<Participante> listaParticipantes){
        return listaParticipantes.stream().map(CpfParticipanteNomeDto::new).collect(Collectors.toList());
    }
}
