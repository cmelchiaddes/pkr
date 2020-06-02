package br.com.mavenpoker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "MOV_GANHO_SEMANAL")
public class GanhosSemanal implements Serializable {

    private static final long serialVersionUID = -7629863745499673469L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data", columnDefinition = "date")
    private Date data;
    @ManyToOne
    private Clube clube;
    @OneToMany(mappedBy = "ganhoSemanal", fetch = FetchType.LAZY)
    private List<Ppst> listaPpst;
    // ganhos do Jogador
    // private Double ganhosJogadorGeral; METODO SOMA DOS ITENS
    private Double ganhosJogadorDeAdversario;
    private Double ganhosJogadorDividirEv;
    private Double ganhosJogadorSeguro;
    private Double ganhosJogadorJackpot;
    // ganhador do clube
    // private Double ganhosDoClube; METODO SOMA DOS ITENS
    private Double ganhosClubeTaxa;
    private Double ganhosClubeTaxaJackpot;
    private Double ganhosClubePremiosJackpot;
    private Double ganhosClubeDividirEv;
    private Double ganhosClubeSeguro;
    private Double ganhosClubeValorTicket;
    private Double ganhosClubeBuyInTicket;
    private boolean possuiPpst;

    /**
     * Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
     *
     * @return
     */
    public Double calcGanhosJogadorGeral() {
        // SOMA DE TODOS OS CAMPOS JOGADOR
        Double resultado = ganhosJogadorDeAdversario + ganhosJogadorDividirEv + ganhosJogadorSeguro
                + ganhosJogadorJackpot;
        // CALC COM OU SEM PPST
        if (possuiPpst) return resultado;
        // Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
        return resultado + (-422.12);
    }

    public Double calcGanhosClubeGeral() {
        // Como Geral do Ganho do CLUBE é uma formula, estou executando ela.
        Double resultado = ganhosClubeTaxa + ganhosClubeTaxaJackpot + ganhosClubePremiosJackpot + ganhosClubeDividirEv + ganhosClubeSeguro + ganhosClubeValorTicket + ganhosClubeBuyInTicket;
        // CALC COM OU SEM PPST
        if (possuiPpst) return resultado;
        // Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
        return resultado + 88;
    }

    // CALCULOS GERAIS SEM PPST//

    /**
     * CALC GANHOS E PERCAS GERAIS
     */
    public Double calcGanhosPerca() {
        // SOMA DOS GANHOS GERAIS DO JOGADOR E DO CLUBE
        return calcGanhosJogadorGeral() + calcGanhosClubeGeral();
    }

    /**
     * CALC DE RAKE DA LIGA
     */
    public Double calcRakeLiga() {
        // GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
        // return calcGanhosClubeGeral() * -clube.getPorcentagemRake();
        return ganhosClubeTaxa + 88;
    }


    // CALC  APNEAS RAKE
    public Double calcRakeFinal() {
        // GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
        // return calcGanhosJogadorGeral() * -clube.getPorcentagemRake();
        return calcRakeLiga() * -0.06;
    }

    // CALC REPOSICAO DE FICHA - GANHOS GERAIS DO JOGADOR * PORCENTAGEM DE RAKE DO
    // CLUBE
    public Double calcReposicaoFicha() {
        // GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
        // return calcGanhosJogadorGeral() * -clube.getPorcentagemRake();
        return calcGanhosPerca() * -0.06;
    }

    // CALC JACKPOT - SOMA DA TAXA JACKPOT COM PREMIO JACKPOT
    // CLUBE
    public Double calcJacpot() {
        // GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
        // return calcGanhosJogadorGeral() * -clube.getPorcentagemRake();
        return getGanhosClubeTaxaJackpot() + getGanhosClubePremiosJackpot();
    }


    // -------- CALC TOTAL ----------
    public Double calcTotal() {
        // GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
        return calcGanhosPerca() + calcReposicaoFicha() + calcRakeFinal() + calcJacpot();
    }

    public String getResultados() {
        return "Clube = " + clube.getNome() + "\nGanhos Geral Jogador = " + calcGanhosJogadorGeral()
                + "\nGeral Clube = " + calcGanhosClubeGeral()
                + "\n\nGanhos e Percas = " + calcGanhosPerca()
                + "\nRake da Liga = " + calcRakeLiga()
                + "\nRake = " + calcRakeFinal()
                + "\nReposicao de fichas = " + calcReposicaoFicha()
                + "\nJackpot = " + calcJacpot()
                + "\nTOTAL = " + calcTotal();
    }

}
