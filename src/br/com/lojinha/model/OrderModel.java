package br.com.lojinha.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private List<Item> itemList;

    public OrderModel(Integer id) {
        this.id = id;
    }

    public OrderModel() {
        itemList = new ArrayList<>();
    }

    public void add(Item item){
        if(item != null)
            this.itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Item itemList) {
        this.itemList.add(itemList);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
