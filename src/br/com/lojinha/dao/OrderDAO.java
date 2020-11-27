package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.OrderModel;
import javax.persistence.EntityManager;
import java.util.List;

public class OrderDAO {

    public OrderModel save(OrderModel order){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return order;
    }

    public void update(OrderModel order){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            if(order.getId() != null){
                entityManager.merge(order);
                entityManager.getTransaction().commit();
            }
        } catch (Exception ignored){
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public OrderModel findById(Integer id){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        OrderModel order = null;
        try {
            order = entityManager.find(OrderModel.class, id);
            if(order == null)
                throw new NullPointerException("Lote não encontrado no sistema.");
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return order;
    }

    public List<OrderModel> findAll(){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<OrderModel> orderModels = null;
        try {
            orderModels = entityManager.createQuery("from Product").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return orderModels;
    }
}
