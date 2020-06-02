package br.com.mavenpoker.dal;

import br.com.mavenpoker.factories.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Logger;

public abstract class Dao<T, ID extends Object> {

    private final EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final Class<T> clazz;

    public Dao(Class<T> clazz) {
        this.entityManagerFactory = EntityManagerFactoryService.getEntityManagerFactory("pkr");
        this.clazz = clazz;
    }

    public Optional<T> findById(ID id) {
        logger.info("Executando consulta para classe " + clazz.getSimpleName());
        return (Optional<T>) executeQuery(etm -> Optional.ofNullable(etm.find(clazz, id)), false);
    }

    public Optional<List<T>> findByNamedQuery(String queryName, Map<String, Object> parameters) {
        logger.info("Executando consulta nomeada para classe " + clazz.getSimpleName());
        return (Optional<List<T>>) executeQuery(etm -> {
            Query namedQuery = etm.createNamedQuery(queryName);
            if (parameters != null) {
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    namedQuery.setParameter(entry.getKey(), entry.getValue());
                }
            }
            return Optional.ofNullable(namedQuery.getResultList());
        }, false);
    }

    public void saveOrUpdate(T object) {
        executeQuery(etm -> {
            if (isIdPersent(object)) {
                logger.info("Atualizando dados para objeto " + object);
                etm.merge(object);
            } else {
                logger.info("Salvando dados para objeto " + object);
                etm.persist(object);
            }
            return null;
        }, true);
    }

    public void delete(T object) {
        logger.info("Deletando objeto" + object);
        executeQuery(etm -> {
            etm.remove(object);
            return null;
        }, true);
    }

    private boolean isIdPersent(T object) {
        try {
            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    field.setAccessible(true);
                    return field.get(object) != null;
                }
            }
        } catch (Exception ex) {
        }
        return false;
    }

    private Optional<?> executeQuery(Function<EntityManager, Optional<?>> function, boolean autoClose) {
        logger.info("Criando EntityManager");
        entityManager = entityManagerFactory.createEntityManager();
        logger.info("Iniciando transação");
        entityManager.getTransaction().begin();
        Optional<?> result = function.apply(entityManager);
        logger.info("Commitando transação");
        logger.info("Fechando EntityManager");
        if (autoClose) {
            closeSession();
        }
        return result;
    }

    public void closeSession() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
