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
            if (count == 5) {
                break;
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = searchable;
                return;
            }
        }
    }

    public Searchable bestResultFound(String search) throws BestResultNotFound{
//s.getSearchTerm().indexOf(search, index);
//
//        String str = "helloabcdehellonnnnnnhello";// это у нас вызов метода getSearchTerm
//        в наших объектах Searchable/ это у меня -----s.getSearchTerm()-----
//        String substring = "Hello";// это сам String search
        int count = 0;
        int index = 0;
        int bestResult = 0;
        int bestIndex = 0;

        for (int i = 0; i < list.length; i++) {
            if(list[i]== null){
                throw new BestResultNotFound(search);
            }
            int subStringIndex = list[i].getSearchTerm().indexOf(search, index);
            //если тут ничего нет, то будет -1
            while (subStringIndex != -1) {
                count++;
                index = subStringIndex + search.length();
                subStringIndex = list[i].getSearchTerm().indexOf(search, index);
            }
            if (bestResult <= count) {
                bestResult = count;
                bestIndex = i;
            }
            count = 0;
            index =0;

        }
        return list[bestIndex];
    }


}
