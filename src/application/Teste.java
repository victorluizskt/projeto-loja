package application;

import br.com.lojinha.dao.UserDAO;
import br.com.lojinha.model.User;

public class Teste {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Victor Luiz");
        user.setPassword("12345678");
        user.setEmail("victorluizcefet@gmail.com");
        user.setUsername("victorluizskt");
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
    }
}
