package application;

import br.com.lojinha.dao.*;
import br.com.lojinha.model.*;
import java.util.Calendar;

public class Teste {
    public static void main(String[] args) {
       GenericDAO<Lot> lotGenericDAO = new GenericDAO<Lot>();
       Calendar c = Calendar.getInstance();
       c.set(Calendar.YEAR, 2021);
       c.set(Calendar.MONTH, Calendar.APRIL);
       c.set(Calendar.DAY_OF_MONTH, 5);
       Lot lot = new Lot();
       lot.setQuantityLot(10);
       lot.setValidityLot(c);
       lotGenericDAO.saveOrUpdate(lot);
    }
}
