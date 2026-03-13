package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;
import java.util.Random;

public class App {

    static Random random = new Random();

    public static String[] namesOfProduct = {"Простоквашино ", "Дядя Ваня ", "Столичная ", "Рафаелло ", "Киндер сюрприз ", "Хлеб ", "Мистер Рико "};

    public static Product[] initialProducts() {
        Product[] local = new Product[random.nextInt(5, 7)];
        for (int i = 0; i < local.length; i++) {
            local[i] = new SimpleProduct(namesOfProduct[random.nextInt(0, namesOfProduct.length - 1)], random.nextInt(125, 500));
        }
        return local;
    }


    public static void main() {
//        Добавление продукта в корзину. 1
        Product[] randomBasket = initialProducts();
        Product[] notRandomBasket = new Product[5];
        Product product1 = new SimpleProduct("Папа может ", 320);
        Product product2 = new SimpleProduct("Булка столичная ", 32);
        Product product3 = new SimpleProduct("Майонез Махеев", 120);
        Product product4 = new SimpleProduct("Чай Greenfield 100пак", 320);
        Product product5 = new SimpleProduct("Конфеты RotFront 0.5кг ", 250);
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
        basketRandomType.addProductInTheBasket(new SimpleProduct("Столичная", 300));
        System.out.println(" ");

        randomBasket[3] = null;

        System.out.println("------------Добавление продукта в корзину.-------------1");
        basketRandomType.addProductInTheBasket(new SimpleProduct("Столичная", 300));
        basketRandomType.printInfoAboutBasket();
        System.out.println(" ");

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места");
        basketNotRandomType.addProductInTheBasket(new SimpleProduct("Столичная", 300));
        System.out.println(" ");

        notRandomBasket[3] = null;

        System.out.println("-Печать содержимого корзины с несколькими товарами.---3");
        basketNotRandomType.printInfoAboutBasket();
        System.out.println(" ");

        System.out.println("------------Добавление продукта в корзину.-------------1");
        basketNotRandomType.addProductInTheBasket(new SimpleProduct("Столичная", 300));
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
        System.out.println(" ");

        DiscountedProduct reebokTapki = new DiscountedProduct("Шлёпки Reebok", 2000, 50);
        DiscountedProduct reebokPants = new DiscountedProduct("Шорты Reebok", 3000, 50);
        FixPriceProduct wire = new FixPriceProduct("Зарядка");
        FixPriceProduct tea = new FixPriceProduct("Чай");

        randomBasket[0] = reebokPants;
        randomBasket[1] = reebokTapki;
        randomBasket[2] = wire;
        randomBasket[3] = tea;
        randomBasket[4] = product1;

        System.out.println("-Печать содержимого корзины с разными товарами товарами.---3");
        basketRandomType.printInfoAboutBasket();

//        System.out.println("wire.getStringRepresentation(wire) = " + wire.getStringRepresentation(wire));

        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.add(wire);
        searchEngine.add(reebokPants);
        searchEngine.add(reebokTapki);
        searchEngine.add(tea);
        searchEngine.add(product1);

        System.out.println(Arrays.toString(searchEngine.search("Reebok")));

        Article article = new Article("Объявление:", "Ручка от шкафа");
        Article article2 = new Article("Объявление:", "Полка от комода");
        Article article3 = new Article("Объявление:", "Ручка от двери");
        Article article4 = new Article("Объявление:", "Ручка от комода");
        Article article5 = new Article("Объявление:", "Полка от шкафа");

        SearchEngine searchArticle = new SearchEngine(5);
        searchArticle.add(tea);
        searchArticle.add(article2);
        searchArticle.add(article5);
        searchArticle.add(article);
        searchArticle.add(wire);

        System.out.println(Arrays.toString(searchArticle.search("Ручка")));
        System.out.println(Arrays.toString(searchArticle.search("Полка")));
        System.out.println(Arrays.toString(searchArticle.search("шкафа")));

        try {
            SimpleProduct safeMED = new SimpleProduct("SafeMED", -100);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            DiscountedProduct safeMED = new DiscountedProduct("Safe", -3,15);
        }catch (IllegalArgumentException e){
            System.out.println((e));
        }try {
            DiscountedProduct safeMED = new DiscountedProduct("Snikers", 100,-2);
        }catch (IllegalArgumentException e){
            System.out.println((e));
        }
        System.out.println(" ");

        SearchEngine searchEngine1 = new SearchEngine(5);
//        reebokPants = null;// переключать для теста
        SimpleProduct rerere = new SimpleProduct("ReefReekReel",300);
        searchEngine1.add(wire);
        searchEngine1.add(reebokTapki);
        searchEngine1.add(tea);
        searchEngine1.add(rerere);
        searchEngine1.add(reebokPants);
        try {
            System.out.println("bestResultFound = " + searchEngine1.bestResultFound("Ree"));

        }catch (BestResultNotFound e){
            System.out.println(e);
        }



    }
}
