package com.uptc.fwr.feria;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("feria");
    }

    public static EntityManager getEntityManagerFactory(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
