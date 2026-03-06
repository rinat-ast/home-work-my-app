package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int priceS) {
        super(name);
        this.price = priceS;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.getName() + " : " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

}



