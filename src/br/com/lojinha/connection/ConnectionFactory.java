package br.com.lojinha.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @brief Classe User
 * @author Victor Luiz Gonçalves
 * @date 24/11/2020
 * @since 24/11/2020
 *
 * Classe responsável em abrir a conexão com o banco de dados.
 *
 */
public class ConnectionFactory {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("funcionaPU");

    /**
     *
     * Metódo responsável por retornar uma conexão para as classes DAO.
     */
    public EntityManager getConnection(){
        return entityManagerFactory.createEntityManager();
    }

}