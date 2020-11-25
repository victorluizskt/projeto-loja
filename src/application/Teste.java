package application;

import br.com.lojinha.dao.ProductDAO;
import br.com.lojinha.dao.UserDAO;
import br.com.lojinha.model.*;

import java.util.Calendar;

public class Teste {
    public static void main(String[] args) {
        Sale sale = new Sale();
        Order order = new Order();

        Product product;
        ProductDAO productDAO = new ProductDAO();
        product = productDAO.findById(1);

        Item item = new Item(product, product.getPriceProduct(), 5);

        order.add(item);

        product = productDAO.findById(2);
        item = new Item(product, product.getPriceProduct(), 2);

        order.add(item);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1995);
        c.set(Calendar.MONTH, Calendar.MARCH);
        c.set(Calendar.DAY_OF_MONTH, 20);


        UserDAO userDAO = new UserDAO();
        User user = userDAO.findById(1);
        sale.setUser(user);
        sale.setDateSale(c);
        sale.setOrder(order);

    }
}
