package br.com.lojinha.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {

    @OneToMany
    private List<Item> itemList = new ArrayList<>();

    public void add(Item item){
        if(item != null)
            itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}

