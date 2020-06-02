package br.com.mavenpoker;

import br.com.mavenpoker.dal.ClubeDao;
import br.com.mavenpoker.models.Clube;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Clube clube = new Clube(null, "Clube de Teste", 1D, new ArrayList(), new ArrayList());
        ClubeDao clubeDao = new ClubeDao();
        clubeDao.saveOrUpdate(clube);
        System.out.println(clubeDao.findById(1L).orElse(null));
        clubeDao.closeSession();
        System.out.println(clubeDao.findByNamedQuery("Clube.findByNome", new HashMap<String, Object>() {
            {
                put("nome", "Clube de Teste");
            }
        }));
        clubeDao.closeSession();
        clube.setNome("Clube de Teste 2");
        clubeDao.saveOrUpdate(clube);
        clubeDao.saveOrUpdate(new Clube(null, "Clube de Teste 3", 1D, new ArrayList(), new ArrayList()));
        clubeDao.findByNamedQuery("Clube.findAll", null).orElse(new ArrayList<>()).forEach(System.out::println);
        clubeDao.closeSession();
    }

}
