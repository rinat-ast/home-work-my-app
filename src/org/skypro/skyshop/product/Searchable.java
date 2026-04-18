package org.skypro.skyshop.product;

 public interface Searchable {

    String getSearchTerm();

    String getTypeContent();

    default String getStringRepresentation() {
        return "Имя " + getSearchTerm() + " тип " + getTypeContent();
    }


 }
