package org.skypro.skyshop.product;

public class FixPriceProduct extends Product  {
    final static int FIXED_PRICE = 100;
    private String name;

    public FixPriceProduct(String name) {
        super(name);

    }


    public int getPrice(){
        return FIXED_PRICE;
    }
    @Override
    public String toString() {
        return name +  " : " + getPrice();
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}

