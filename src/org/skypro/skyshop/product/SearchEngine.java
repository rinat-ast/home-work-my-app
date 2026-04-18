package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {
    private HashSet<Searchable> list;

    public SearchEngine(HashSet list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SearchEngine. Список: " + list;
    }

//            Принимает в себя строку для поиска и возвращает 5 результатов
//            поиска по массиву Searchable в виде массива из 5 элементов.
//           <-- Внимание!!! Изменение логики метода!!! -->
//            Измените метод поиска: он должен возвращать *все*
//            подходящие результаты (а не 5 результатов, как раньше).

//    public HashMap<String,LinkedList<Product>> search(String text) {
//        System.out.println("SearchEngine.search");
//        HashMap<String,LinkedList<Product>> result = new HashMap<>();
//        for (Searchable search : list) {
//            if (search.getSearchTerm().contains(text)) {
//                result.put(search);
//            }
//        }
//        return result;
//    }

    public TreeSet<Searchable> searchAndSort(String text) {
        TreeSet<Searchable> result = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable s1, Searchable s2) {
                int lengthComp = Integer.compare
                        (s2.getSearchTerm().length(), s1.getSearchTerm().length());
                if (lengthComp != 0) {
                    return lengthComp;
                }
                return s1.getSearchTerm().compareTo(s2.getSearchTerm());
            }
        });
        for (Searchable search : list) {
            if (search.getSearchTerm().contains(text)) {
                result.add(search);
            }
        }
        return result;
    }




    // этот метод нужен при Linkedlist поле?
    public void add(Searchable searchable) {
                list.add(searchable);
    }

//     Реализуйте в классе SearchEngine метод, который находит среди объектов Searchable
//     наиболее подходящий к поисковой строке и возвращает его.
//     Метод должен принимать строку search, а возвращать объект Searchable.
//     Наиболее подходящим назовем объект типа Searchable. Его метод getSearchTerm()
//     содержит максимальное количество повторов строки search.
//     Если таких объектов несколько, то вернуть можно любой из них.

    public Searchable bestResultFound(String search) throws BestResultNotFound {
        System.out.println("SearchEngine.bestResultFound");
        int count = 0;
        int index = 0;
        int bestResult = 0;
        Searchable bestIndex = null;

        for (Searchable searchable : list) {
            if (searchable == null) {
                throw new BestResultNotFound(search);
            }
            int subStringIndex = searchable.getSearchTerm().indexOf(search, index);
            //если тут ничего нет, то будет -1
            while (subStringIndex != -1) {
                count++;
                index = subStringIndex + search.length();
                subStringIndex = searchable.getSearchTerm().indexOf(search, index);
            }
            if (bestResult <= count) {
                bestResult = count;
                bestIndex = searchable;
            }
            count = 0;
            index = 0;

        }
        return bestIndex;
    }


}
