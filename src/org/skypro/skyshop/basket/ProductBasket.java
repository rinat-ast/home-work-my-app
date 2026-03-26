package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ProductBasket {
    private String customer;
    private HashMap<String, LinkedList<Product>> basket;

    public ProductBasket(String customer, HashMap<String, LinkedList<Product>> basket) {
        this.customer = customer;
        this.basket = basket;
    }

    public HashMap<String, LinkedList<Product>> getBasket() {
        return basket;
    }

    //     1   Метод добавления продукта в корзину:
//     метод принимает в себя продукт и ничего не возвращает.
    public void addProductInTheBasket(Product product) {
        String key = product.getName();
        basket.computeIfAbsent(key, k -> new LinkedList<>()).add(product);
    }


// 2  Метод получения общей стоимости корзины:
//    метод ничего не принимает и возвращает целое число.

    public int totalSumPriceOfBasket() {
        System.out.println("ProductBasket.totalSumPriceOfBasket");
        int totalSum = 0;
        for (Map.Entry<String, LinkedList<Product>> keyName : basket.entrySet()) {
            for (Product product : keyName.getValue()) {
                totalSum += product.getPrice();
            }
        }
        return totalSum;
    }

    // 3 Метод, который печатает содержимое корзины:
//   метод ничего не принимает и не возвращает,
//   но печатает в консоль сообщение:
    public void printInfoAboutBasket() {
        System.out.println("ProductBasket.printInfoAboutBasket");
        int countSpecialProducts = 0;//для подсчёта спец.товаров
        int totalSum = 0;//для подсчёта суммы всей корзины
        int count = 0; // для подсчёта не Null элементов
        for (Map.Entry<String, LinkedList<Product>> keyName : basket.entrySet()) {
            for (Product product : keyName.getValue()) {
                if (product == null) {
                    continue;
                }
                count++;
                if (product.isSpecial()) {
                    countSpecialProducts++;
                }
                System.out.println(product);
                totalSum += product.getPrice();
            }
            if (count == 0) {
                System.out.println("В корзине пусто");
            }
        }
        System.out.println("================");
        System.out.println("Итого: " + totalSum);
        System.out.println("Кол-во спец. товаров " + countSpecialProducts);
    }

//    4  Метод, проверяющий продукт в корзине по имени:
//    метод принимает в себя строку имени и возвращает boolean
//    в зависимости от того, есть продукт в корзине или его нет.
    public boolean checkProductInTheBasket(String productName) {
        System.out.println("ProductBasket.checkProductInTheBasket");
        for (Map.Entry<String, LinkedList<Product>> pr : basket.entrySet()) {
            for (Product product : pr.getValue()) {
                if (product == null) {
                    continue;
                }
                if (product.getName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    //     5  Метод очистки корзины: метод ничего не принимает и очищает массив,
//         проставляя всем его элементам null
    public void cleanTheBasket() {
        System.out.println("ProductBasket.cleanTheBasket");
        basket.clear();
    }
//2. Добавление метода удаления продукта по имени из корзины
//   Теперь добавьте метод, который по переданному имени продукта удаляет все продукты с таким именем из корзины:
//   Метод должен принимать строку name и возвращать список (List) удаленных продуктов.
//    Если продукта нет в корзине, то возвращаемый список должен быть пустым.

    public boolean removeProduct(String Key) {
        if (basket.containsKey(Key)) {
            basket.remove(Key);
            return true;
        }
        return false;
    }


    public LinkedList<Product> advancedRemoveProduct(String name) {
        System.out.println("ProductBasket.advancedRemoveProduct");
        LinkedList<Product> removeList = new LinkedList<>();
        for (Map.Entry<String, LinkedList<Product>> pr : basket.entrySet()) {
            Iterator<Product> iterator = pr.getValue().iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().contains(name)) {
                    removeList.add(product);
                    iterator.remove();
                }
            }
        }
        if (removeList.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeList;


    }
}
