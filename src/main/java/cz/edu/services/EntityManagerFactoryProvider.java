package cz.edu.services;

import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFactoryProvider {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");

    public EntityManagerFactory getEmf() {
        return emf;
    }

    @PreDestroy
    public void onDetroy()  {
        emf.close();
    }
}