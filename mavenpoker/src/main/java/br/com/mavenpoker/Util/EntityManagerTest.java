package br.com.mavenpoker.Util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {

    protected static EntityManagerFactory entityManagerFactory;

    protected static EntityManager entityManager;
 
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("postgres");
    }

    public static void tearDownAfterClass() {
        entityManagerFactory.close();
    }

    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void tearDown() {
        entityManager.close();
    }
}