package br.com.mavenpoker.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clube")
public class Clube {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private Double porcentagemRake;

	@OneToMany(mappedBy = "clube", fetch = FetchType.LAZY)
	private List<GanhosSemanal> listaGanhosSemanais;

	@OneToMany(mappedBy = "clube", fetch = FetchType.LAZY)
	private List<PPST> listaPPST;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaGanhosSemanais == null) ? 0 : listaGanhosSemanais.hashCode());
		result = prime * result + ((listaPPST == null) ? 0 : listaPPST.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((porcentagemRake == null) ? 0 : porcentagemRake.hashCode());
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
		Clube other = (Clube) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaGanhosSemanais == null) {
			if (other.listaGanhosSemanais != null)
				return false;
		} else if (!listaGanhosSemanais.equals(other.listaGanhosSemanais))
			return false;
		if (listaPPST == null) {
			if (other.listaPPST != null)
				return false;
		} else if (!listaPPST.equals(other.listaPPST))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (porcentagemRake == null) {
			if (other.porcentagemRake != null)
				return false;
		} else if (!porcentagemRake.equals(other.porcentagemRake))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPorcentagemRake() {
		return porcentagemRake;
	}

	public void setPorcentagemRake(Double porcentagemRake) {
		this.porcentagemRake = porcentagemRake;
	}

	public List<GanhosSemanal> getListaGanhosSemanais() {
		return listaGanhosSemanais;
	}

	public void setListaGanhosSemanais(List<GanhosSemanal> listaGanhosSemanais) {
		this.listaGanhosSemanais = listaGanhosSemanais;
	}

	public List<PPST> getListaPPST() {
		return listaPPST;
	}

	public void setListaPPST(List<PPST> listaPPST) {
		this.listaPPST = listaPPST;
	}

	@Override
	public String toString() {
		return "Clube [id=" + id + ", nome=" + nome + ", porcentagemRake=" + porcentagemRake + "]";
	}

}
