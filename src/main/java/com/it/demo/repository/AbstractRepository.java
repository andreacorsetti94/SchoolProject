package com.it.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class AbstractRepository {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EntityManager entityManager;

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
