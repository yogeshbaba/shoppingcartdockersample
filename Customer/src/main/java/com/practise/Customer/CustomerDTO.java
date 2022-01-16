package com.practise.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerDTO {

    private Integer id;
    private String name;
    private Integer age;
    private Map<Integer,ItemDTO> cart = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<Integer, ItemDTO> getCart() {
        return cart;
    }

    public void removeCart(Integer itemID){
        this.cart.remove(itemID);
    }
    public void addOrUpdateCart(Integer itemID, ItemDTO itemDTO){
        this.cart.put(itemID, itemDTO);
    }

}
