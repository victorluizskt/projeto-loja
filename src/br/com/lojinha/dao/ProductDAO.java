package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.Lot;
import br.com.lojinha.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDAO {
    public Product save(Product product){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return product;
    }

    public void update(Product product){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            if(product.getCodeProduct() != null){
                entityManager.merge(product);
                entityManager.getTransaction().commit();
            }
        } catch (Exception ignored){
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public Product findById(Integer id){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Product product = null;
        try {
            product = entityManager.find(Product.class, id);
            if(product == null)
                throw new NullPointerException("Lote não encontrado no sistema.");
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return product;
    }

    public List<Product> findAll(){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Product> productList = null;
        try {
            productList = entityManager.createQuery("from Product").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return productList;
    }
}
