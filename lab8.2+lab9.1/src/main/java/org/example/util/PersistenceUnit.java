package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class PersistenceUnit {
    private Map properties;
    private static PersistenceUnit instance;
    private Connection connection;
    EntityManagerFactory factory;
    EntityManager em;

    public PersistenceUnit() {
        this.factory = Persistence.createEntityManagerFactory("MyApplicationPU", this.properties);
        this.em = this.factory.createEntityManager();
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static PersistenceUnit getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new PersistenceUnit();
        }

        return instance;
    }
}

