package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basicPrice;
    private int discount;


    public DiscountedProduct(String name, int basicPrice, int discount) {
        super(name);
        this.basicPrice = basicPrice;
        this.discount = discount;

    }
    @Override
    public int getPrice(){
        return (basicPrice/100) * (100 - discount);
    }
    public int getDiscount() {
        return discount;
    }

    public String toString() {
        return super.getName() + " : " + getPrice() + " : (" + discount + "%)";
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}
