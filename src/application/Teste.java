package application;

import br.com.lojinha.dao.ItemDAO;
import br.com.lojinha.dao.LotDAO;
import br.com.lojinha.dao.ProductDAO;
import br.com.lojinha.dao.UserDAO;
import br.com.lojinha.model.Item;
import br.com.lojinha.model.Lot;
import br.com.lojinha.model.Product;
import br.com.lojinha.model.User;

import java.util.Calendar;

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
