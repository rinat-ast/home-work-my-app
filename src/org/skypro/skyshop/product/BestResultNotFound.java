package org.skypro.skyshop.product;

public class BestResultNotFound extends Exception{
    private String name;

    public BestResultNotFound(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "BestResultNotFound{" +
                " такое имя как " + name + " не найдено }";
    }
}
