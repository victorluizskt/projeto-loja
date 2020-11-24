package br.com.lojinha.model;

import javax.persistence.*;
import java.util.Objects;
/*
 * @brief Classe User
 * @author Victor Luiz Gonçalves
 * @date 10/11/2020
 * @since 10/11/2020
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeProduct;
    private String nameProduct;
    private double priceProduct;
    @ManyToOne
    private Lot lotProduct;

    public Product(int codeProduct, String nameProduct, double priceProduct, Lot lotProduct) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.lotProduct = lotProduct;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(int codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Lot getLotProduct() {
        return lotProduct;
    }

    public void setLotProduct(Lot lotProduct) {
        this.lotProduct = lotProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return codeProduct == product.codeProduct &&
                nameProduct.equals(product.nameProduct) &&
                lotProduct.equals(product.lotProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeProduct, nameProduct, priceProduct, lotProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "codeProduct=" + codeProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct='" + priceProduct + '\'' +
                ", lotProduct=" + lotProduct +
                '}';
    }
}
