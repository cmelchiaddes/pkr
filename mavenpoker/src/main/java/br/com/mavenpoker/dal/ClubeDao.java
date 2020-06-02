package br.com.mavenpoker.dal;

import br.com.mavenpoker.models.Clube;

public class ClubeDao extends Dao<Clube, Long> {

    public ClubeDao() {
        super(Clube.class);
    }

}
