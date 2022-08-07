package ru.netology.productManagepr;

import ru.netology.productManager.Product;

public class Smartphone extends Product {

    private String manufactured;

    public Smartphone(int id, String name, int price, String s) {
        super(id, name, price);
        this.manufactured = manufactured;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }
}
