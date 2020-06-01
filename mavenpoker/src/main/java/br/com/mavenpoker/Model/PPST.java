package br.com.mavenpoker.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "PPST")
public class PPST {

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

	public GanhosSemanal getGanhoSemanal() {
		return ganhoSemanal;
	}

	public void setGanhoSemanal(GanhosSemanal ganhoSemanal) {
		this.ganhoSemanal = ganhoSemanal;
	}

	public Double getGanhosJogadorGeral() {
		return ganhosJogadorGeral;
	}

	public void setGanhosJogadorGeral(Double ganhosJogadorGeral) {
		this.ganhosJogadorGeral = ganhosJogadorGeral;
	}

	public Double getGanhosDoClube() {
		return ganhosDoClube;
	}

	public void setGanhosDoClube(Double ganhosDoClube) {
		this.ganhosDoClube = ganhosDoClube;
	}

	public Double getGanhosClubeTaxa() {
		return ganhosClubeTaxa;
	}

	public void setGanhosClubeTaxa(Double ganhosClubeTaxa) {
		this.ganhosClubeTaxa = ganhosClubeTaxa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clube == null) ? 0 : clube.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((ganhoSemanal == null) ? 0 : ganhoSemanal.hashCode());
		result = prime * result + ((ganhosClubeTaxa == null) ? 0 : ganhosClubeTaxa.hashCode());
		result = prime * result + ((ganhosDoClube == null) ? 0 : ganhosDoClube.hashCode());
		result = prime * result + ((ganhosJogadorGeral == null) ? 0 : ganhosJogadorGeral.hashCode());
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
		PPST other = (PPST) obj;
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
		if (ganhoSemanal == null) {
			if (other.ganhoSemanal != null)
				return false;
		} else if (!ganhoSemanal.equals(other.ganhoSemanal))
			return false;
		if (ganhosClubeTaxa == null) {
			if (other.ganhosClubeTaxa != null)
				return false;
		} else if (!ganhosClubeTaxa.equals(other.ganhosClubeTaxa))
			return false;
		if (ganhosDoClube == null) {
			if (other.ganhosDoClube != null)
				return false;
		} else if (!ganhosDoClube.equals(other.ganhosDoClube))
			return false;
		if (ganhosJogadorGeral == null) {
			if (other.ganhosJogadorGeral != null)
				return false;
		} else if (!ganhosJogadorGeral.equals(other.ganhosJogadorGeral))
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
		return "PPST [id=" + id + ", data=" + data + ", clube=" + clube + ", ganhoSemanal=" + ganhoSemanal
				+ ", ganhosJogadorGeral=" + ganhosJogadorGeral + ", ganhosDoClube=" + ganhosDoClube
				+ ", ganhosClubeTaxa=" + ganhosClubeTaxa + "]";
	}

	public Double calcGanhosJogadorGeral() {

		// Como Geral do Ganho dos jogadores é uma formula, estou executando ela.
		return getGanhosJogadorGeral();
	}

	public Double calcGanhosClubeGeral() {

		// Como Geral do Ganho do CLUBE é uma formula, estou executando ela.
		return ganhosClubeTaxa;
	}

}
