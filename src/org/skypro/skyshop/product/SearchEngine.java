package org.skypro.skyshop.product;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private LinkedList<Searchable> list;
//    private final static int SIZE = 5;

    public SearchEngine(LinkedList<Searchable> listS) {
        this.list = listS;
    }


//    public SearchEngine() {
//        this.list = new LinkedList<>();
//    }

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

public TreeMap<String, LinkedList<Searchable>> searchAndSort(String text) {
    TreeMap<String, LinkedList<Searchable>> localList = new TreeMap<>();
    for (Searchable search : list) {
        if (search.getSearchTerm().contains(text)) {
            String key = search.getSearchTerm();
            if (!localList.containsKey(key)) {
                localList.put(key, new LinkedList<>()); // создаём пустой список для ключа
            }
            localList.get(key).add(search); // добавляем объект в список
        }
    }
    return localList;
}
    // этот метод нужен при Linkedlist поле?
    public void add(Searchable searchable) {
        for (Searchable room : list) {
            if (room == null) {
                room = searchable;
            }
        }
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
