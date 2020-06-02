package br.com.mavenpoker.models;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
@EqualsAndHashCode
public class Jogador implements Serializable {

    private static final long serialVersionUID = -6133288950633121843L;
    private Long id;
    private Pais pais;
    private Agente agente;
    private String nick;
    private String nomeMemorando;

}
