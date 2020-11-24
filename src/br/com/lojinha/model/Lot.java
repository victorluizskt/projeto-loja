package br.com.lojinha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
/*
 * @brief Classe User
 * @author Victor Luiz Gonçalves
 * @date 10/11/2020
 * @since 10/11/2020
 */

@Entity
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLot;
    private Date validityLot;
    private int quantityLot;

    public Lot(int idLot, Date validityLot, int quantityLot) {
        this.idLot = idLot;
        this.validityLot = validityLot;
        this.quantityLot = quantityLot;
    }

    public int getIdLot() {
        return idLot;
    }

    public void setIdLot(int idLot) {
        this.idLot = idLot;
    }

    public Date getValidityLot() {
        return validityLot;
    }

    public void setValidityLot(Date validityLot) {
        this.validityLot = validityLot;
    }

    public int getQuantityLot() {
        return quantityLot;
    }

    public void setQuantityLot(int quantityLot) {
        this.quantityLot = quantityLot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot)) return false;
        Lot lot = (Lot) o;
        return idLot == lot.idLot &&
                quantityLot == lot.quantityLot &&
                Objects.equals(validityLot, lot.validityLot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLot, validityLot, quantityLot);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "idLot=" + idLot +
                ", validityLot=" + validityLot +
                ", quantityLot=" + quantityLot +
                '}';
    }
}