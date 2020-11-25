package br.com.lojinha.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codSale;
    private Date dateSale;
    @ManyToOne
    private Order order;
    private User user;

    public Sale(int codSale, Date dateSale, Order order, User user) {
        this.codSale = codSale;
        this.dateSale = dateSale;
        this.order = order;
        this.user = user;
    }

    public int getCodSale() {
        return codSale;
    }

    public void setCodSale(int codSale) {
        this.codSale = codSale;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
                Objects.equals(order, sale.order) &&
                Objects.equals(user, sale.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codSale, dateSale, order, user);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "codSale=" + codSale +
                ", dateSale=" + dateSale +
                ", order=" + order +
                ", client='" + user + '\'' +
                '}';
    }

}