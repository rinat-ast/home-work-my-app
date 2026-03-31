package org.skypro.skyshop.product;


import java.util.Objects;

public abstract class Product implements Searchable,Comparable<Searchable> {
    private final String name;

    public Product(String name) {
        if(name == null || name.isBlank()){
        throw  new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getTypeContent() {
        return  "PRODUCT";
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Product)) return false;
//        return Objects.equals(name, ((Product)o).name);
//    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public int compareTo(Searchable other) {
        int lengthComp = Integer.compare
                (other.getSearchTerm().length(), this.getSearchTerm().length());
        if (lengthComp != 0) {
            return lengthComp;
        }
        return this.getSearchTerm().compareTo(other.getSearchTerm());
    }
}
