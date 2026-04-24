package org.skypro.skyshop.product;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if(this ==o) return true;
        if(o == null || !this.getClass().equals(o.getClass())){
            return false;
        }
        SimpleProduct product = (SimpleProduct)o;
        return Objects.equals(getName(),product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}



