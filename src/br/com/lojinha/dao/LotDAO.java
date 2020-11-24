package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.Lot;
import javax.persistence.EntityManager;
import java.util.List;

public class LotDAO {

    public Lot save(Lot lot){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(lot);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return lot;
    }

    public void update(Lot lot){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            if(lot.getIdLot() != null){
                entityManager.merge(lot);
                entityManager.getTransaction().commit();
            }
        } catch (Exception ignored){
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public Lot findById(Integer id){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Lot lot = null;
        try {
            lot = entityManager.find(Lot.class, id);
            if(lot == null)
                throw new NullPointerException("Lote não encontrado no sistema.");
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return lot;
    }

    public List<Lot> findAll(){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Lot> lotList = null;
        try {
            lotList = entityManager.createQuery("from Lot").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return lotList;
    }
}
