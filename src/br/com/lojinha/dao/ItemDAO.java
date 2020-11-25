package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.Item;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemDAO {

    public Item save(Item item){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            if(item != null)
                entityManager.persist(item);
                entityManager.getTransaction().begin();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return item;
    }

    public List<Item> findAll(){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Item> items = null;
        try {
            items = entityManager.createQuery("from Item").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return items;
    }
}
