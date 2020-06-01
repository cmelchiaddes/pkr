package br.com.mavenpoker.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 


public class HibernateUtil {

    private static final EntityManagerFactory emfAdonai = Persistence.createEntityManagerFactory("pkr");
    //private static final EntityManagerFactory emfAdonai = Persistence.createEntityManagerFactory("adonai-teste-postgres");

    /**
     * Retorna um Entity Manager de Conexao com o banco de dados
     * @return
     */
    public EntityManager getEntityManager() {
            return emfAdonai.createEntityManager();
    }
	
}
 