package br.com.mavenpoker.Model;


import lombok.Builder;
import lombok.Data;
 
@Data
@Builder
public class Jogador {

	private Long id;
	
	//private Pais pais;
	
	//private Agente agente;
	private String nick;
	
	private String nomeMemorando;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNomeMemorando() {
		return nomeMemorando;
	}

	public void setNomeMemorando(String nomeMemorando) {
		this.nomeMemorando = nomeMemorando;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + ((nomeMemorando == null) ? 0 : nomeMemorando.hashCode());
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
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (nomeMemorando == null) {
			if (other.nomeMemorando != null)
				return false;
		} else if (!nomeMemorando.equals(other.nomeMemorando))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nick=" + nick + ", nomeMemorando=" + nomeMemorando + "]";
	}

 
	
	
}
