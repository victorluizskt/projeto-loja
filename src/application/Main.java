package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * @brief Classe User
 * @author Victor Luiz Gonçalves
 * @date 24/11/2020
 * @since 24/11/2020
 *
 * Classe responsável por abrir o FXML e startar a aplicação.
 *
 */


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Your zé shop.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /*
     Sale sale = new Sale();

        Product product;
        ProductDAO productDAO = new ProductDAO();


        product = productDAO.findById(2);
        Item item = new Item();
        item.setProduct(product);
        item.setPriceItem(product.getPriceProduct());
        item.setQuantityItem(10);

        Order order = new Order();
        order.add(item);

        product = productDAO.findById(1);
        Item item2 = new Item();
        item2.setProduct(product);
        item2.setPriceItem(product.getPriceProduct());
        item2.setQuantityItem(10);

        order.add(item2);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1995);
        c.set(Calendar.MONTH, Calendar.MARCH);
        c.set(Calendar.DAY_OF_MONTH, 20);


        UserDAO userDAO = new UserDAO();
        User user = userDAO.findById(1);
        sale.setUser(user);
        sale.setDateSale(c);
        sale.setOrder(order);
        SaleDAO saleDAO = new SaleDAO();
        saleDAO.save(sale);
     */
}