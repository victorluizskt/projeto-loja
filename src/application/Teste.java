package application;

import br.com.lojinha.dao.UserDAO;
import br.com.lojinha.model.User;

public class Teste {
    public static void main(String[] args) {
        User user = new User();
        UserDAO userDAO = new UserDAO();
        user.setName("Gerciana Gonçalves");
        user.setUsername("gercianaccds");
        user.setPassword("6545888549");
        user.setEmail("gercianagoncalves@gmasaail.com");
        userDAO.save(user);
    }
}
