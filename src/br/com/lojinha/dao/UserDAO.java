package br.com.lojinha.dao;

import br.com.lojinha.connection.ConnectionFactory;
import br.com.lojinha.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO {

    public User save(User user){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            if(user.getId() == null && !verifiedEmailAndUser(user)) {
                entityManager.persist(user);
                entityManager.getTransaction().commit();
            } else {
                throw new IllegalArgumentException("Email ou usuário já existente.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return user;
    }

    public void update(User user){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            if(user.getId() != null){
                entityManager.merge(user);
                entityManager.getTransaction().commit();
            }
        } catch (Exception ignored){
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public User findById(Integer id){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        User user = null;
        try {
            user = entityManager.find(User.class, id);
            if(user == null){
                throw new NullPointerException("Usuário não encontrado no sistema.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return user;
    }

    public List<User> findAll(){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<User> userList = null;
        try {
            userList = entityManager.createQuery("from User").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return userList;
    }

    /**
     *
     *  Metódo responsável por verificar se tenho algum email ou username repetido, sendo assim proibindo
     * a função save de salvar users e emails repetidos.
     * @param user Necessário para verificar com minha lista.
     */
    private boolean verifiedEmailAndUser(User user){
        List<User> userList = findAll();
        for (User value : userList) {
            if (value.getEmail().equals(user.getEmail()) || value.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}