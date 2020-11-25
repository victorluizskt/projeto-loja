package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.Sale;

import javax.persistence.EntityManager;

public class SaleDAO {

    public Sale save(Sale sale){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(sale);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return sale;
    }
}
