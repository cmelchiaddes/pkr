package br.com.mavenpoker.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GanhosSemanal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private Date data;

	@ManyToOne
	private Clube clube;

	@OneToMany(mappedBy = "ganhoSemanal", fetch = FetchType.LAZY)
	private List<PPST> listaPPST;
	
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
	
	@OneToMany
	private List<PPST> listaPpst;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	public Double getGanhosJogadorDeAdversario() {
		return ganhosJogadorDeAdversario;
	}

	public void setGanhosJogadorDeAdversario(Double ganhosJogadorDeAdversario) {
		this.ganhosJogadorDeAdversario = ganhosJogadorDeAdversario;
	}

	public Double getGanhosJogadorDividirEv() {
		return ganhosJogadorDividirEv;
	}

	public void setGanhosJogadorDividirEv(Double ganhosJogadorDividirEv) {
		this.ganhosJogadorDividirEv = ganhosJogadorDividirEv;
	}

	public Double getGanhosJogadorSeguro() {
		return ganhosJogadorSeguro;
	}

	public void setGanhosJogadorSeguro(Double ganhosJogadorSeguro) {
		this.ganhosJogadorSeguro = ganhosJogadorSeguro;
	}

	public Double getGanhosJogadorJackpot() {
		return ganhosJogadorJackpot;
	}

	public void setGanhosJogadorJackpot(Double ganhosJogadorJackpot) {
		this.ganhosJogadorJackpot = ganhosJogadorJackpot;
	}

	public Double getGanhosClubeTaxa() {
		return ganhosClubeTaxa;
	}

	public void setGanhosClubeTaxa(Double ganhosClubeTaxa) {
		this.ganhosClubeTaxa = ganhosClubeTaxa;
	}

	public Double getGanhosClubeTaxaJackpot() {
		return ganhosClubeTaxaJackpot;
	}

	public void setGanhosClubeTaxaJackpot(Double ganhosClubeTaxaJackpot) {
		this.ganhosClubeTaxaJackpot = ganhosClubeTaxaJackpot;
	}

	public Double getGanhosClubePremiosJackpot() {
		return ganhosClubePremiosJackpot;
	}

	public void setGanhosClubePremiosJackpot(Double ganhosClubePremiosJackpot) {
		this.ganhosClubePremiosJackpot = ganhosClubePremiosJackpot;
	}

	public Double getGanhosClubeDividirEv() {
		return ganhosClubeDividirEv;
	}

	public void setGanhosClubeDividirEv(Double ganhosClubeDividirEv) {
		this.ganhosClubeDividirEv = ganhosClubeDividirEv;
	}

	public Double getGanhosClubeSeguro() {
		return ganhosClubeSeguro;
	}

	public void setGanhosClubeSeguro(Double ganhosClubeSeguro) {
		this.ganhosClubeSeguro = ganhosClubeSeguro;
	}

	public Double getGanhosClubeValorTicket() {
		return ganhosClubeValorTicket;
	}

	public void setGanhosClubeValorTicket(Double ganhosClubeValorTicket) {
		this.ganhosClubeValorTicket = ganhosClubeValorTicket;
	}

	public Double getGanhosClubeBuyInTicket() {
		return ganhosClubeBuyInTicket;
	}

	public void setGanhosClubeBuyInTicket(Double ganhosClubeBuyInTicket) {
		this.ganhosClubeBuyInTicket = ganhosClubeBuyInTicket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clube == null) ? 0 : clube.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((ganhosClubeBuyInTicket == null) ? 0 : ganhosClubeBuyInTicket.hashCode());
		result = prime * result + ((ganhosClubeDividirEv == null) ? 0 : ganhosClubeDividirEv.hashCode());
		result = prime * result + ((ganhosClubePremiosJackpot == null) ? 0 : ganhosClubePremiosJackpot.hashCode());
		result = prime * result + ((ganhosClubeSeguro == null) ? 0 : ganhosClubeSeguro.hashCode());
		result = prime * result + ((ganhosClubeTaxa == null) ? 0 : ganhosClubeTaxa.hashCode());
		result = prime * result + ((ganhosClubeTaxaJackpot == null) ? 0 : ganhosClubeTaxaJackpot.hashCode());
		result = prime * result + ((ganhosClubeValorTicket == null) ? 0 : ganhosClubeValorTicket.hashCode());
		result = prime * result + ((ganhosJogadorDeAdversario == null) ? 0 : ganhosJogadorDeAdversario.hashCode());
		result = prime * result + ((ganhosJogadorDividirEv == null) ? 0 : ganhosJogadorDividirEv.hashCode());
		result = prime * result + ((ganhosJogadorJackpot == null) ? 0 : ganhosJogadorJackpot.hashCode());
		result = prime * result + ((ganhosJogadorSeguro == null) ? 0 : ganhosJogadorSeguro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GanhosSemanal other = (GanhosSemanal) obj;
		if (clube == null) {
			if (other.clube != null)
				return false;
		} else if (!clube.equals(other.clube))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (ganhosClubeBuyInTicket == null) {
			if (other.ganhosClubeBuyInTicket != null)
				return false;
		} else if (!ganhosClubeBuyInTicket.equals(other.ganhosClubeBuyInTicket))
			return false;
		if (ganhosClubeDividirEv == null) {
			if (other.ganhosClubeDividirEv != null)
				return false;
		} else if (!ganhosClubeDividirEv.equals(other.ganhosClubeDividirEv))
			return false;
		if (ganhosClubePremiosJackpot == null) {
			if (other.ganhosClubePremiosJackpot != null)
				return false;
		} else if (!ganhosClubePremiosJackpot.equals(other.ganhosClubePremiosJackpot))
			return false;
		if (ganhosClubeSeguro == null) {
			if (other.ganhosClubeSeguro != null)
				return false;
		} else if (!ganhosClubeSeguro.equals(other.ganhosClubeSeguro))
			return false;
		if (ganhosClubeTaxa == null) {
			if (other.ganhosClubeTaxa != null)
				return false;
		} else if (!ganhosClubeTaxa.equals(other.ganhosClubeTaxa))
			return false;
		if (ganhosClubeTaxaJackpot == null) {
			if (other.ganhosClubeTaxaJackpot != null)
				return false;
		} else if (!ganhosClubeTaxaJackpot.equals(other.ganhosClubeTaxaJackpot))
			return false;
		if (ganhosClubeValorTicket == null) {
			if (other.ganhosClubeValorTicket != null)
				return false;
		} else if (!ganhosClubeValorTicket.equals(other.ganhosClubeValorTicket))
			return false;
		if (ganhosJogadorDeAdversario == null) {
			if (other.ganhosJogadorDeAdversario != null)
				return false;
		} else if (!ganhosJogadorDeAdversario.equals(other.ganhosJogadorDeAdversario))
			return false;
		if (ganhosJogadorDividirEv == null) {
			if (other.ganhosJogadorDividirEv != null)
				return false;
		} else if (!ganhosJogadorDividirEv.equals(other.ganhosJogadorDividirEv))
			return false;
		if (ganhosJogadorJackpot == null) {
			if (other.ganhosJogadorJackpot != null)
				return false;
		} else if (!ganhosJogadorJackpot.equals(other.ganhosJogadorJackpot))
			return false;
		if (ganhosJogadorSeguro == null) {
			if (other.ganhosJogadorSeguro != null)
				return false;
		} else if (!ganhosJogadorSeguro.equals(other.ganhosJogadorSeguro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GanhosSemanal [ GeralJogador = " + calcGanhosJogadorGeral() + "data=" + data + " clube="
				+ clube.getNome() + ", ganhosJogadorDeAdversario=" + ganhosJogadorDeAdversario
				+ ", ganhosJogadorDividirEv=" + ganhosJogadorDividirEv + ", ganhosJogadorSeguro=" + ganhosJogadorSeguro
				+ ", ganhosJogadorJackpot=" + ganhosJogadorJackpot + ", GeralCLube=" + calcGanhosClubeGeral()
				+ ", ganhosClubeTaxa=" + ganhosClubeTaxa + ", ganhosClubeTaxaJackpot=" + ganhosClubeTaxaJackpot
				+ ", ganhosClubePremiosJackpot=" + ganhosClubePremiosJackpot + ", ganhosClubeDividirEv="
				+ ganhosClubeDividirEv + ", ganhosClubeSeguro=" + ganhosClubeSeguro + ", ganhosClubeValorTicket="
				+ ganhosClubeValorTicket + ", ganhosClubeBuyInTicket=" + ganhosClubeBuyInTicket + " ]";

		// return "GanhosSemanal [ GeralJogador = "+ calcGanhosJogadorGeral() + ",
		// GeralCLube=" + calcGanhosClubeGeral() + " ]";
	}

	public Double calcGanhosJogadorGeral() {

		// Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
		// SOMA DE TODOS OS CAMPOS JOGADOR
		Double resultado = ganhosJogadorDeAdversario + ganhosJogadorDividirEv + ganhosJogadorSeguro
				+ ganhosJogadorJackpot;
		// CALC COM OU SEM PPST
		if (possuiPpst) {

			return resultado;
		} else {
			// Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
			return resultado + -422.12;

		}
	}

	public Double calcGanhosClubeGeral() {

		// Como Geral do Ganho do CLUBE é uma formula, estou executando ela.
		Double resultado = ganhosClubeTaxa + ganhosClubeTaxaJackpot + ganhosClubePremiosJackpot + ganhosClubeDividirEv
				+ ganhosClubeSeguro + ganhosClubeValorTicket + ganhosClubeBuyInTicket;

		// CALC COM OU SEM PPST
		if (possuiPpst) {

			return resultado;
		} else {
			// Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
			return resultado + 88;

		}
	}

	// -----------------------------------//
	//
	// CALCULOS GERAIS SEM PPST//
	//
	// -----------------------------------//

	// CALC GANHOS E PERCAS GERAIS
	public Double calcGanhosPerca() {

		// SOMA DOS GANHOS GERAIS DO JOGADOR E DO CLUBE
		return calcGanhosJogadorGeral() + calcGanhosClubeGeral();
	}

	// CALC DE RAKE DA LIGA
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
		return calcGanhosPerca() +  calcReposicaoFicha() + calcRakeFinal() + calcJacpot();
	}

	public void mostraResultados() {
		System.out.println("Clube = " + clube.getNome() + "\nGanhos Geral Jogador = " + calcGanhosJogadorGeral()
				+ "\nGeral Clube = " + calcGanhosClubeGeral() 
				+ "\n\nGanhos e Percas = " + calcGanhosPerca()
				+ "\nRake da Liga = " + calcRakeLiga() 
				+ "\nRake = " + calcRakeFinal()
				+ "\nReposicao de fichas = " + calcReposicaoFicha()
				+ "\nJackpot = " + calcJacpot()
				
				+ "\nTOTAL = " + calcTotal());
	}

}
