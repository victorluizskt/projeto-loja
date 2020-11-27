package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GenericDAO<T extends BaseEntity> {

    private ConnectionFactory factory = new ConnectionFactory();
    private EntityManager manager;

    public T findById(Class<T> clazz, Integer id) {
        T t = null;

        try {
            manager = factory.getConnection();
            t = manager.find(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }

        return t;
    }

    public T saveOrUpdate(T t) {

        try {
            manager = factory.getConnection();
            manager.getTransaction().begin();
            if (t.getId() == null) {
                manager.persist(t);
            } else {
                manager.merge(t);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }

        return t;
    }

    public T remove(Class<T> clazz, Integer id) {
        T t = null;
        try {
            manager = factory.getConnection();
            t = findById(clazz, id);
            manager.getTransaction().begin();
            manager.remove(t);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }

        return t;
    }

    public List<T> findAll(Class<T> clazz) {
        List<T> list = null;

        try {
            manager = factory.getConnection();
            list = manager.createQuery("from " + clazz.getSimpleName()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }

        return list;
    }

    public <C extends BaseEntity> List<T> findByFk(Class<T> clazz, C c) {
        Integer id = c.getId();
        List<T> list = null;

        try {
            manager = factory.getConnection();
            Query query = manager.createQuery("select obj from " + clazz.getSimpleName() + " obj where obj.id = :id");
            query.setParameter("id", id);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }

        return list;
    }
}