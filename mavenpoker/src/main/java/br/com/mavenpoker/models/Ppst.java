package br.com.mavenpoker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "MOV_PPST")
public class Ppst implements Serializable {

    private static final long serialVersionUID = -7896821982933191287L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    @ManyToOne
    private Clube clube;
    @ManyToOne
    private GanhosSemanal ganhoSemanal;
    // ganhos do Jogador
    private Double ganhosJogadorGeral;
    // ganhador do clube
    private Double ganhosDoClube;
    private Double ganhosClubeTaxa;

    /**
     * Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
     *
     * @return
     */
    public Double calcGanhosJogadorGeral() {
        return ganhosJogadorGeral;
    }

    /**
     * Como Geral do Ganho do CLUBE é uma formula, estou executando ela.
     *
     * @return
     */
    public Double calcGanhosClubeGeral() {
        return ganhosClubeTaxa;
    }

}
