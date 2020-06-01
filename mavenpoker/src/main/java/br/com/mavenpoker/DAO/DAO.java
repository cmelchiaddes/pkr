package br.com.mavenpoker.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.mavenpoker.Util.HibernateUtil;
 

public class DAO<T> {

	private static Logger logger = Logger.getLogger(DAO.class);

	private Class<T> persistentClass;

	private Session session = HibernateUtil.getSession();

	public DAO(Class<T> persistentClass) {

		this.persistentClass = persistentClass;

	}
	@SuppressWarnings("unchecked")
	public T buscaSemStatus(Long id) {

		session.beginTransaction().begin();

		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.eq("id", id));
		T objeto = (T) c.uniqueResult();

		// objeto = (T) session.load(persistentClass, id);
		logger.info("LendoGenerico " + persistentClass + " com id " + id);
		session.beginTransaction().commit();
		return objeto;
	}
	@SuppressWarnings("unchecked")
	public T buscaGenericaIdSemStatus(String coluna, Long id) {

		session.beginTransaction().begin();
		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.eq(coluna, id));
		T objeto = (T) c.uniqueResult();

		// objeto = (T) session.load(persistentClass, id);
		logger.info("LendoGenerico " + persistentClass + " com id " + id);
		session.beginTransaction().commit();
		return objeto;
	}
	@SuppressWarnings("unchecked")
	public T buscaGenericaStatus(String coluna, String nome, String coluna2,
			String nome2) {

		session.beginTransaction().begin();

		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.ilike(coluna, nome, MatchMode.ANYWHERE));
		c.add(Restrictions.ilike(coluna2, nome2, MatchMode.ANYWHERE));
		T objeto = (T) c.uniqueResult();
		
		session.beginTransaction().commit();
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public T busca(Long id) {

		session.beginTransaction().begin();

		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.eq("id", id));
		c.add(Restrictions.eq("status", true));
		T objeto = (T) c.uniqueResult();

		// objeto = (T) session.load(persistentClass, id);
		logger.info("LendoGenerico " + persistentClass + " com id " + id);
		session.beginTransaction().commit();
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public T busca(int id) {

		session.beginTransaction().begin();

		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.eq("id", id));
		c.add(Restrictions.eq("status", true));
		T objeto = (T) c.uniqueResult();

		// objeto = (T) session.load(persistentClass, id);
		logger.info("LendoGenerico " + persistentClass + " com id " + id);
		session.beginTransaction().commit();
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public T busca(String idString) {

		session.beginTransaction().begin();
		Long id = Long.parseLong(idString);
		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.eq("id", id));
		c.add(Restrictions.eq("status", true));
		T objeto = (T) c.uniqueResult();

		// objeto = (T) session.load(persistentClass, id);
		logger.info("LendoGenerico " + persistentClass + " com id " + id);
		session.beginTransaction().commit();
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public T buscaGenericaId(String coluna, Long id) {

		session.beginTransaction().begin();
		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.eq(coluna, id));
		c.add(Restrictions.eq("status", true));
		T objeto = (T) c.uniqueResult();

		// objeto = (T) session.load(persistentClass, id);
		logger.info("LendoGenerico " + persistentClass + " com id " + id);
		session.beginTransaction().commit();
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaGenerica(String coluna, String nome) {

		session.beginTransaction().begin();
		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.ilike(coluna, nome, MatchMode.ANYWHERE));
		c.add(Restrictions.eq("status", true));

		session.beginTransaction().commit();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaGenerica(String coluna, Long numero) {

		session.beginTransaction().begin();
		Criteria c = session.createCriteria(persistentClass);

		c.add(Restrictions.eq(coluna, numero));

		c.add(Restrictions.eq("status", true));

		session.beginTransaction().commit();
		return c.list();

	}

	@SuppressWarnings("unchecked")
	public List<T> buscaGenerica(String coluna, int numero) {

		session.beginTransaction().begin();
		Criteria c = session.createCriteria(persistentClass);

		c.add(Restrictions.eq(coluna, numero));

		c.add(Restrictions.eq("status", true));

		session.beginTransaction().commit();
		return c.list();

	}

	@SuppressWarnings("unchecked")
	public List<T> buscaGenerica(String coluna, String nome, String coluna2,
			String nome2) {

		session.beginTransaction().begin();

		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.ilike(coluna, nome, MatchMode.ANYWHERE));
		c.add(Restrictions.ilike(coluna2, nome2, MatchMode.ANYWHERE));
		c.add(Restrictions.eq("status", true));

		session.beginTransaction().commit();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaLogin(String coluna, String nome, String coluna2,
			String nome2) {

		session.beginTransaction().begin();

		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.eq(coluna, nome));
		c.add(Restrictions.eq(coluna2, nome2));
		c.add(Restrictions.eq("status", true));

		session.beginTransaction().commit();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaGenerica(String coluna, Long idColuna, String coluna2,
			Long idColuna2) {

		session.beginTransaction().begin();

		Criteria c = session.createCriteria(persistentClass);

		c.add(Restrictions.eq(coluna, idColuna));
		c.add(Restrictions.eq(coluna2, idColuna2));

		c.add(Restrictions.eq("status", true));

		session.beginTransaction().commit();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaLista() {

		session.beginTransaction().begin();
		Criteria c = session.createCriteria(persistentClass);
		c.add(Restrictions.eq("status", true));
		List<T> lista = c.list();

		// session.beginTransaction().begin();
		// logger.info("ListandoTodosGenerico " + persistentClass );
		// List<T> lista = session.createCriteria(persistentClass).list();
		session.beginTransaction().commit();
		return lista;
	}

	public void salva(T t) {
		session.beginTransaction().begin();
		logger.info("SalvandoGenerico " + t);
		session.save(t);
		session.beginTransaction().commit();

	}

	public void atualiza(T t) {
		session.beginTransaction().begin();
		logger.info("AtualizandoGenerico " + t);
		session.update(t);
		session.beginTransaction().commit();
	}

	public void merge(T t) {

		logger.info("Salvando ou atualizando" + t);
		session.merge(t);
	}

	public void deleta(T t) {
		session.beginTransaction().begin();
		logger.info("DeletandoGenerico do id = " + t);
		session.update(t);
		session.beginTransaction().commit();
	}
	
 
	/*
	 * Codigo para deletar realmente do Banco public void remove(T t){
	 * session.beginTransaction().begin();
	 * logger.info("DeletandoGenerico do id = " + t); session.delete(t);
	 * session.beginTransaction().commit(); }
	 */

}
