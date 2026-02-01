package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.sql.SQLOutput;

public class ProductBasket {
    private String customer;
    private Product[] basket = new Product[5];

    public ProductBasket(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    public Product[] getBasket() {
        return basket;
    }

    //     1   Метод добавления продукта в корзину:
//     метод принимает в себя продукт и ничего не возвращает.
    public void addProductInTheBasket(Product product) {
        boolean isAdded = false;
        System.out.println("--ProductBasket.addProductInTheBasket--");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                isAdded = true;
                break;
            }
        }
        if (!isAdded) {
            System.out.println("Невозможно добавить продукт");
        }
    }
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
        int totalSum = 0;
        int count = basket.length;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
//                System.out.println("Null");
                count -= 1;
                continue;
            }
            System.out.println(basket[i].getName() + " : " + basket[i].getPrice());
            totalSum += basket[i].getPrice();
        }
        if (count == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + totalSum);

        }
    }

    // 4  Метод, проверяющий продукт в корзине по имени:
//    метод принимает в себя строку имени и возвращает
//    boolean
//    в зависимости от того, есть продукт в корзине или его нет.
    public boolean checkProductInTheBasket(String productName) {
        System.out.println("ProductBasket.checkProductInTheBasket");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                continue;
            }
            if (basket[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }


// 5  Метод очистки корзины: метод ничего не принимает и очищает массив,
//    проставляя всем его элементам null
public void cleanTheBasket() {
    System.out.println("ProductBasket.cleanTheBasket");
    for (int i = 0; i < basket.length; i++) {
        basket[i] = null;

    }
}

}
