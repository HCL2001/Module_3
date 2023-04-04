package com.example.genshin_food.Models;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private int id;
    private Food food;
    private List<Item> items;
    private int status;
    private int total;
    private int quantity = 1;

    public Cart() {
        this.status = 0;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total += total;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
