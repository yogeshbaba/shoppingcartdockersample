package com.practise.Customer;

import java.util.List;

public class CartDTO {

    private Integer id;
    private List<ItemDTO> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
