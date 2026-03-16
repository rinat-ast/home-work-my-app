package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    private String customer;
    private LinkedList<Product> basket;

    public ProductBasket(String customer, LinkedList<Product> basket) {
        this.customer = customer;
        this.basket = basket;
    }

    public  LinkedList<Product> getBasket() {
        return basket;
    }

    //     1   Метод добавления продукта в корзину:
//     метод принимает в себя продукт и ничего не возвращает.
//    public void addProductInTheBasket(Product product) {
//        boolean isAdded = false;
//        System.out.println("--ProductBasket.addProductInTheBasket--");
//        for (int i = 0; i < basket.length; i++) {
//            if (basket[i] == null) {
//                basket[i] = product;
//                isAdded = true;
//                break;
//            }
//        }
//        if (!isAdded) {
//            System.out.println("Невозможно добавить продукт");
//        }
//    }

// 2  Метод получения общей стоимости корзины:
//    метод ничего не принимает и возвращает целое число.

    public int totalSumPriceOfBasket() {
        System.out.println("ProductBasket.totalSumPriceOfBasket");
        int totalSum = 0;
        for (Product product : basket) {
            if (product == null) {
                continue;
            }
            totalSum += product.getPrice();
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
        for (Product product : basket) {
            if (product == null) {
//                System.out.println("Null");
                continue;
            }
            count ++;
            if (product.isSpecial()){
//            if (basket[i].getClass() != SimpleProduct.class) {так можно было?
                countSpecialProducts ++;
            }
            System.out.println(product);
            totalSum += product.getPrice();
        }
        if (count == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + totalSum);

        }
        System.out.println("Кол-во спец. товаров " + countSpecialProducts);
    }

    // 4  Метод, проверяющий продукт в корзине по имени:
//    метод принимает в себя строку имени и возвращает
//    boolean
//    в зависимости от того, есть продукт в корзине или его нет.
    public boolean checkProductInTheBasket(String productName) {
        System.out.println("ProductBasket.checkProductInTheBasket");
        for (Product product : basket) {
            if (product == null) {
                continue;
            }
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }


    // 5  Метод очистки корзины: метод ничего не принимает и очищает массив,
//    проставляя всем его элементам null
    public void cleanTheBasket() {
        System.out.println("ProductBasket.cleanTheBasket");
        for (Product product : basket) {
            product = null;

        }
    }
    public LinkedList<Product> removeProduct(String name) {
        System.out.println("ProductBasket.removeProduct");
        LinkedList<Product> removeList = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (name.equals(product.getName())) {
                removeList.add(product);
                iterator.remove();
            }

        }
        if (removeList.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeList;
    }

    public LinkedList<Product> advancedRemoveProduct (String name){
        System.out.println("ProductBasket.advancedRemoveProduct");
        LinkedList<Product> removeList = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().contains(name)) {
                removeList.add(product);
                iterator.remove();
            }
        }
        if (removeList.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeList;
    }

}
