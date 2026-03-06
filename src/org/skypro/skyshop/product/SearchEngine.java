package org.skypro.skyshop.product;

public class SearchEngine {
     private Searchable[] list;
//    private final static int SIZE = 5;


    public SearchEngine(int size) {
        this.list = new Searchable[size];
    }

    @Override
    public String toString() {
        return "super.toString()";
    }

    public Searchable[] search(String text) {
        Searchable[] result = new Searchable[5];
        int count = 0;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i].getSearchTerm().contains(text)) {
                result[count] = list[i];
                count++;
            }
            if(count == 5){
                break;
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i <list.length; i++) {
            if (list[i] == null){
                list[i] = searchable;
                return;
            }
        }
    }
}
