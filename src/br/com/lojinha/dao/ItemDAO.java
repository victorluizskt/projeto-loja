package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.Item;
import br.com.lojinha.model.OrderModel;
import br.com.lojinha.model.Product;

import javax.persistence.EntityManager;

public class ItemDAO {
    public Item save(Item item){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return item;
    }

    public Item findById(Integer id){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Item item = null;
        try {
            item = entityManager.find(Item.class, id);
            if(item == null)
                throw new NullPointerException("Lote não encontrado no sistema.");
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return item;
    }
}
