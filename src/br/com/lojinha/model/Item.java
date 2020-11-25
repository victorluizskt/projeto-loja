package br.com.lojinha.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Item {

    @ManyToOne
    private Product product;

    private double priceItem;
    private int quantityItem;

    public Item(Product product, double priceItem, int quantityItem) {
        this.product = product;
        this.priceItem = priceItem;
        this.quantityItem = quantityItem;
    }

    public Item(){

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(double priceItem) {
        this.priceItem = priceItem;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.priceItem, priceItem) == 0 &&
                quantityItem == item.quantityItem &&
                Objects.equals(product, item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, priceItem, quantityItem);
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", priceItem=" + priceItem +
                ", quantityItem=" + quantityItem +
                '}';
    }
}
