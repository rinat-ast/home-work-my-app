package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int priceS)  {
        if(priceS <= 0){
            throw new IllegalArgumentException("Название товара не может быть пустым или null");
        }
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



