package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Random;

public class App {

    static Random random = new Random();

    public static String[] namesOfProduct = {"Простоквашино ", "Дядя Ваня ", "Столичная ", "Рафаелло ", "Киндер сюрприз ", "Хлеб ", "Мистер Рико "};

    public static Product[] initialProducts() {
        Product[] local = new Product[random.nextInt(5, 7)];
        for (int i = 0; i < local.length; i++) {
            local[i] = new Product(namesOfProduct[random.nextInt(0, namesOfProduct.length - 1)], random.nextInt(125, 500));
        }
        return local;
    }

    public static void main() {
//        Добавление продукта в корзину. 1
        Product[] randomBasket = initialProducts();
        Product[] notRandomBasket = new Product[5];
        Product product1 = new Product("Папа может ", 320);
        Product product2 = new Product("Булка столичная ", 32);
        Product product3 = new Product("Майонез Махеев", 120);
        Product product4 = new Product("Чай Greenfield 100пак", 320);
        Product product5 = new Product("Конфеты RotFront 0.5кг ", 250);
//        Добавление продукта в корзину. 1
        notRandomBasket[0] = product1;
        notRandomBasket[1] = product2;
        notRandomBasket[2] = product3;
        notRandomBasket[3] = product4;
        notRandomBasket[4] = product5;

        System.out.println("---Объявили объект класса ProductBasket-------");
        ProductBasket basketNotRandomType = new ProductBasket("Bob", notRandomBasket);
        basketNotRandomType.printInfoAboutBasket();
        System.out.println(" ");

        System.out.println("---Объявили объект класса ProductBasket-------");
        ProductBasket basketRandomType = new ProductBasket("Trump", randomBasket);
        basketRandomType.printInfoAboutBasket();
        System.out.println(" ");

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места");
        basketRandomType.addProductInTheBasket(new Product("Столичная", 300));
        System.out.println(" ");

        randomBasket[3] = null;

        System.out.println("------------Добавление продукта в корзину.-------------1");
        basketRandomType.addProductInTheBasket(new Product("Столичная", 300));
        basketRandomType.printInfoAboutBasket();
        System.out.println(" ");

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места");
        basketNotRandomType.addProductInTheBasket(new Product("Столичная", 300));
        System.out.println(" ");

        notRandomBasket[3] = null;

        System.out.println("-Печать содержимого корзины с несколькими товарами.---3");
        basketNotRandomType.printInfoAboutBasket();
        System.out.println(" ");

        System.out.println("------------Добавление продукта в корзину.-------------1");
        basketNotRandomType.addProductInTheBasket(new Product("Столичная", 300));
        System.out.println(" ");

        System.out.println("basketNotRandomType. полная стоимость = " + basketNotRandomType.totalSumPriceOfBasket());
        System.out.println(" ");

        System.out.println("basketRandomType. полная стоимость = " + basketRandomType.totalSumPriceOfBasket());
        System.out.println(" ");

        System.out.println("Поиск товара, который есть в корзине.");
        System.out.println("checkProductInTheBasket = " + basketNotRandomType.checkProductInTheBasket("Дядя Ваня "));
        System.out.println(" ");

        System.out.println("Поиск товара, которого нет в корзине");
        System.out.println("checkProductInTheBasket = " + basketNotRandomType.checkProductInTheBasket("Uncle Bob "));
        System.out.println(" ");

        System.out.println("Поиск товара, который есть в корзине. 2");
        System.out.println("checkProductInTheBasket =  " + basketRandomType.checkProductInTheBasket("Дядя Ваня "));
        System.out.println(" ");

        System.out.println("-------Очистка корзины.--------------------------7");
        basketRandomType.cleanTheBasket();
        System.out.println(" ");

        System.out.println("--------Печать содержимого пустой корзины. -------8");
        basketRandomType.printInfoAboutBasket();
        System.out.println(" ");

        System.out.println("-------Получение стоимости пустой корзины.---------9");
        System.out.println("basketRandomType.totalSumPriceOfBasket() = " + basketRandomType.totalSumPriceOfBasket());
        System.out.println(" ");


        System.out.println("------Поиск товара по имени в пустой корзине------10");
        System.out.println("Дядя Ваня = " + basketRandomType.checkProductInTheBasket("Дядя Ваня "));


    }
}
