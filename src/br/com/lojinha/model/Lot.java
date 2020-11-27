package br.com.lojinha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Objects;
/*
 * @brief Classe User
 * @author Victor Luiz Gonçalves
 * @date 24/11/2020
 * @since 24/11/2020
 *
 * Classe lote.
 */

@Entity
public class Lot implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLot;
    private Calendar validityLot;
    private int quantityLot;

    public Lot(Integer idLot, Calendar validityLot, int quantityLot) {
        this.idLot = idLot;
        this.validityLot = validityLot;
        this.quantityLot = quantityLot;
    }
    public Lot(){

    }
    public Integer getIdLot() {
        return idLot;
    }

    public void setIdLot(Integer idLot) {
        this.idLot = idLot;
    }

    public Calendar getValidityLot() {
        return validityLot;
    }

    public void setValidityLot(Calendar validityLot) {
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
        return idLot.equals(lot.idLot) &&
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

    @Override
    public Integer getId() {
        return null;
    }

    /*
       Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1995);
        c.set(Calendar.MONTH, Calendar.MARCH);
        c.set(Calendar.DAY_OF_MONTH, 20);
        Lot lot = new Lot();
        LotDAO lotDAO = new LotDAO();
        lot.setValidityLot(c);
        lot.setQuantityLot(10);
        lotDAO.save(lot);
     */
}