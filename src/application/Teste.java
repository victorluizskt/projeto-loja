package application;

import br.com.lojinha.dao.*;
import br.com.lojinha.model.*;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.Calendar;

public class Teste {
    public static void main(String[] args) {
       Calendar c = Calendar.getInstance();
       c.set(Calendar.YEAR, 1995);
       c.set(Calendar.MONTH, Calendar.MARCH);
       c.set(Calendar.DAY_OF_MONTH, 20);
       UserDAO userDAO = new UserDAO();
       User user = userDAO.findById(1);

       OrderDAO orderDAO = new OrderDAO();
       OrderModel order = orderDAO.findById(3);
       orderDAO.save(order);

       Sale sale = new Sale();
       sale.setUser(user);
       sale.setOrder(order);
       sale.setDateSale(c);

       SaleDAO saleDAO = new SaleDAO();
       saleDAO.save(sale);
    }
}
