package application;

import br.com.lojinha.dao.UserDAO;
import br.com.lojinha.model.User;

public class Teste {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Gerson Gonçalves");
        user.setUsername("gersonskt");
        user.setPassword("123645897");
        user.setEmail("gerson@gmail.com");
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);

    }
}
