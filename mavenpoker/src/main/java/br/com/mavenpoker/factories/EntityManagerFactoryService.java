package br.com.mavenpoker.factories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public abstract class EntityManagerFactoryService {

    private static final Map<String, EntityManagerFactory> factories = new HashMap();

    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName) {
        if (factories.containsKey(persistenceUnitName)) return factories.get(persistenceUnitName);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        factories.put(persistenceUnitName, entityManagerFactory);
        return entityManagerFactory;
    }

    public static void closeFactories() {
        factories.values().stream().forEach(EntityManagerFactory::close);
        factories.clear();
    }

}
