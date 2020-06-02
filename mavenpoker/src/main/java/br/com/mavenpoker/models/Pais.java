package br.com.mavenpoker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class Pais implements Serializable {

    private static final long serialVersionUID = 3852813058456787677L;
    private Long id;
    private String nome;

}
