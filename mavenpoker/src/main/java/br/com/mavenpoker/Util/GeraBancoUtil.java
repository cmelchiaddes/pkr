package br.com.mavenpoker.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.mavenpoker.Model.Clube;

public class GeraBancoUtil extends EntityManagerTest {

	public static Clube criaCLube() {
		Clube clube = new Clube();

		//clube.setId( 2);
		clube.setNome("Câmera Canon");
		return clube;
	}
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pkr");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	
	public static void main(String[] args) {


		
		System.out.println("ss");
		Clube clube = new Clube();

		//clube.setId((double) 2);
		clube.setNome("Câmera Canon");
		clube.setPorcentagemRake((double) 6);
		
		entityManager.getTransaction().begin();
		entityManager.merge(clube);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
		
	}
 
}