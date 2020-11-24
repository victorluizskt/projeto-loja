package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.User;

import javax.persistence.EntityManager;

public class UserDAO {
    private final EntityManager entityManager = new ConnectionFactory().getConnection();

    public User save(User user){
        try {
            entityManager.getTransaction().begin();
            if(user.getId() == null) {
                entityManager.persist(user);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return user;
    }
}