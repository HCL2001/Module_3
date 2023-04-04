package com.example.genshin_food.Models;

import java.util.List;

public class Order {
    private int idOrder;
    private String dateOrder;
    private String addressOrder;
    private int total;
    private int status;

    private Item item;


    private String phoneNumber;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getStatus() {
        return status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private List<Item> itemList;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Order() {
        this.status = 0;
    }

    public Order(int idOrder, String dateOrder, String addressOrder, int total, String phoneNumber) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.addressOrder = addressOrder;
        this.total = total;
        this.phoneNumber = phoneNumber;
    }

    public Order(int idOrder, String dateOrder, String addressOrder, String phoneNumber, int total, int status) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.addressOrder = addressOrder;
        this.phoneNumber = phoneNumber;
        this.total = total;
        this.status = status;
    }
}
