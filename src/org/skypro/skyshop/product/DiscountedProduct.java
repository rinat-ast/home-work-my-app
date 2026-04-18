package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product{
    private int basicPrice;
    private int discount;


    public DiscountedProduct(String name, int basicPrice, int discount) {
        if(basicPrice <= 0){
            throw new IllegalArgumentException("Чёт с ценной");
        }
        if(discount < 0 || discount > 100){
            throw new IllegalArgumentException("со скидкой траблы братан");
        }
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
    @Override
    public boolean equals(Object o) {
        if(this ==o) return true;
        if(o == null || !this.getClass().equals(o.getClass())){
            return false;
        }
        DiscountedProduct product = (DiscountedProduct)o;
        return Objects.equals(getName(),product.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

}
