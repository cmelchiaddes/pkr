package br.com.mavenpoker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

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
    // private BigDecimal ganhosJogadorGeral; METODO SOMA DOS ITENS
    private BigDecimal ganhosJogadorDeAdversario = new BigDecimal(0);
    private BigDecimal ganhosJogadorDividirEv = new BigDecimal(0);
    private BigDecimal ganhosJogadorSeguro = new BigDecimal(0);
    private BigDecimal ganhosJogadorJackpot = new BigDecimal(0);
    // ganhador do clube
    // private BigDecimal ganhosDoClube; METODO SOMA DOS ITENS
    private BigDecimal ganhosClubeTaxa = new BigDecimal(0);
    private BigDecimal ganhosClubeTaxaJackpot = new BigDecimal(0);
    private BigDecimal ganhosClubePremiosJackpot = new BigDecimal(0);
    private BigDecimal ganhosClubeDividirEv = new BigDecimal(0);
    private BigDecimal ganhosClubeSeguro = new BigDecimal(0);
    private BigDecimal ganhosClubeValorTicket = new BigDecimal(0);
    private BigDecimal ganhosClubeBuyInTicket = new BigDecimal(0);
    private boolean possuiPpst = false;

    /**
     * Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
     *
     * @return
     */
    public BigDecimal calcularGanhosJogadorGeral() {
        return calcular(rst -> possuiPpst ? rst : rst.add(new BigDecimal(-422.12)),
                ganhosJogadorDeAdversario, ganhosJogadorDividirEv, ganhosJogadorSeguro, ganhosJogadorJackpot);
    }

    /**
     * Como Geral do Ganho do CLUBE é uma formula, estou executando ela.
     *
     * @return
     */
    public BigDecimal calcularGanhosClubeGeral() {
        return calcular(rst -> possuiPpst ? rst : rst.add(new BigDecimal(88)),
                ganhosClubeTaxa, ganhosClubeTaxaJackpot, ganhosClubePremiosJackpot, ganhosClubeDividirEv, ganhosClubeSeguro, ganhosClubeValorTicket, ganhosClubeBuyInTicket);
    }

    // CALCULOS GERAIS SEM PPST//

    /**
     * CALC GANHOS E PERCAS GERAIS
     * SOMA DOS GANHOS GERAIS DO JOGADOR E DO CLUBE
     */
    public BigDecimal calcularGanhosPerca() {
        return calcularGanhosJogadorGeral().add(calcularGanhosClubeGeral());
    }

    /**
     * CALC DE RAKE DA LIGA
     * GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
     */
    public BigDecimal calcularRakeLiga() {
        return ganhosClubeTaxa.add(new BigDecimal(88));
    }

    /**
     * CALC  APNEAS RAKE
     * GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
     */
    public BigDecimal calcularRakeFinal() {
        return calcularRakeLiga().multiply(new BigDecimal(-0.06));
    }

    /**
     * CALC REPOSICAO DE FICHA - GANHOS GERAIS DO JOGADOR * PORCENTAGEM DE RAKE DO CLUBE
     * GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
     */
    public BigDecimal calcularReposicaoFicha() {
        return calcularGanhosPerca().multiply(new BigDecimal(-0.06));
    }

    /**
     * CALC JACKPOT - SOMA DA TAXA JACKPOT COM PREMIO JACKPOT CLUBE
     * GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
     */
    public BigDecimal calcularJacpot() {
        return getGanhosClubeTaxaJackpot().add(getGanhosClubePremiosJackpot());
    }

    /**
     * Calcula o total
     * GANHOS DO CLUBE X PORCENTAGEM DE RAKE DO CLUBE
     *
     * @return
     */
    public BigDecimal getTotal() {
        return calcularGanhosPerca().add(calcularReposicaoFicha()).add(calcularRakeFinal()).add(calcularJacpot());
    }

    private BigDecimal calcular(Function<BigDecimal, BigDecimal> calculo, BigDecimal... valores) {
        BigDecimal resultado = new BigDecimal(0);
        for (BigDecimal valor : valores) {
            resultado = resultado.add(valor);
        }
        return calculo.apply(resultado);
    }

    public String getResultados() {
        return "Clube = " + clube.getNome() + "\nGanhos Geral Jogador = " + calcularGanhosJogadorGeral()
                + "\nGeral Clube = " + calcularGanhosClubeGeral()
                + "\n\nGanhos e Percas = " + calcularGanhosPerca()
                + "\nRake da Liga = " + calcularRakeLiga()
                + "\nRake = " + calcularRakeFinal()
                + "\nReposicao de fichas = " + calcularReposicaoFicha()
                + "\nJackpot = " + calcularJacpot()
                + "\nTOTAL = " + getTotal();
    }

}
