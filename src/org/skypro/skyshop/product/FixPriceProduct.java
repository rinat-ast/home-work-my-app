package org.skypro.skyshop.product;

import java.util.Queue;

public class FixPriceProduct extends Product  {
    private final static int FIXED_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);

    }

    @Override
    public  int getPrice(){
        return FIXED_PRICE;
    }
    @Override
    public String toString() {
        return super.getName() +  " : " + getPrice();
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}

