package br.com.lojinha.model;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codSale;
    private Calendar dateSale;

    @OneToOne
    private OrderModel orderModel;

    @OneToOne
    private User user;

    public Sale(int codSale, Calendar dateSale, OrderModel orderModel, User user) {
        this.codSale = codSale;
        this.dateSale = dateSale;
        this.orderModel = orderModel;
        this.user = user;
    }

    public Sale(){

    }

    public int getCodSale() {
        return codSale;
    }

    public void setCodSale(int codSale) {
        this.codSale = codSale;
    }

    public Calendar getDateSale() {
        return dateSale;
    }

    public void setDateSale(Calendar dateSale) {
        this.dateSale = dateSale;
    }

    public OrderModel getOrder() {
        return orderModel;
    }

    public void setOrder(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale)) return false;
        Sale sale = (Sale) o;
        return codSale == sale.codSale &&
                Objects.equals(dateSale, sale.dateSale) &&
                Objects.equals(orderModel, sale.orderModel) &&
                Objects.equals(user, sale.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codSale, dateSale, orderModel, user);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "codSale=" + codSale +
                ", dateSale=" + dateSale +
                ", order=" + orderModel +
                ", client='" + user + '\'' +
                '}';
    }

}