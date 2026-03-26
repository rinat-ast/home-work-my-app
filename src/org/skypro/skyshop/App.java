package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.*;

public class App {

    static Random random = new Random();

    public static LinkedList<String> namesOfProduct = new LinkedList<>(Arrays.asList(
            "Простоквашино ", "Дядя Ваня ", "Столичная ", "Рафаелло ", "Киндер сюрприз ", "Хлеб ", "Мистер Рико "));

    public static LinkedList<Product> initialProducts() {
        LinkedList<Product> local = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            local.add(new SimpleProduct(namesOfProduct.get(random.nextInt(0, namesOfProduct.size())), random.nextInt(50, 250)));

        }
        return local;
    }


    public static void main() {
//        Добавление продукта в корзину. 1
        LinkedList<Product> randomBasket = initialProducts();
        LinkedList<Product> notRandomBasket = new LinkedList<Product>();
        HashMap<String, LinkedList<Product>> mapForRandomBasket = new HashMap<>();
        mapForRandomBasket.put("randomName",randomBasket);
        ProductBasket mapR = new ProductBasket("Rendy", mapForRandomBasket);

        HashMap<String, LinkedList<Product>> mapForNotRandomBasket = new HashMap<>();
        mapForNotRandomBasket.put("sombody",notRandomBasket);
        ProductBasket mapNotR = new ProductBasket("Sarah",mapForNotRandomBasket);

        Product product1 = new SimpleProduct("Папа может ", 320);
        Product product2 = new SimpleProduct("Булка столичная ", 32);
        Product product3 = new SimpleProduct("Майонез Махеев", 120);
        Product product4 = new SimpleProduct("Чай Greenfield 100пак", 320);
        Product product5 = new SimpleProduct("Конфеты RotFront 0.5кг ", 250);

//        Добавление продукта в корзину. 1
        notRandomBasket.add(product1);
        notRandomBasket.add(product2);
        notRandomBasket.add(product3);
        notRandomBasket.add(product4);
        notRandomBasket.add(product5);

        System.out.println("---Объявили объект класса ProductBasket-------");
        ProductBasket basketNotRandomType = new ProductBasket("Bob", mapForRandomBasket);
        basketNotRandomType.printInfoAboutBasket();
        System.out.println(" ");

        System.out.println("---Объявили объект класса ProductBasket-------");
        ProductBasket basketRandomType = new ProductBasket("Trump", mapForRandomBasket);
        basketRandomType.printInfoAboutBasket();
        System.out.println(" ");

//        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места");
//        basketRandomType.addProductInTheBasket(new SimpleProduct("Столичная", 300));
//        System.out.println(" ");
//
//
//        System.out.println("------------Добавление продукта в корзину.-------------1");
//        basketRandomType.addProductInTheBasket(new SimpleProduct("Столичная", 300));
//        basketRandomType.printInfoAboutBasket();
//        System.out.println(" ");
//
//        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места");
//        basketNotRandomType.addProductInTheBasket(new SimpleProduct("Столичная", 300));
//        System.out.println(" ");


        System.out.println("-Печать содержимого корзины с несколькими товарами.---3");
        basketNotRandomType.printInfoAboutBasket();
        System.out.println(" ");

//        System.out.println("------------Добавление продукта в корзину.-------------1");
//        basketNotRandomType.addProductInTheBasket(new SimpleProduct("Столичная", 300));
//        System.out.println(" ");

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
        randomBasket.add(reebokPants);
        randomBasket.add(reebokTapki);
        randomBasket.add(wire);
        randomBasket.add(tea);
        randomBasket.add(product1);


        System.out.println("-Печать содержимого корзины с разными товарами товарами.---3");
        basketRandomType.printInfoAboutBasket();
        System.out.println(" ");

//        System.out.println("wire.getStringRepresentation(wire) = " + wire.getStringRepresentation(wire));
        LinkedList<Searchable> list1 = new LinkedList<>();
        list1.add(product3);
        list1.add(reebokPants);
        list1.add(reebokTapki);
        list1.add(tea);
        list1.add(product1);
        SearchEngine searchEngine = new SearchEngine(list1);

//        System.out.println("searchEngine.search(\"Reebok\") = " + searchEngine.search("Reebok"));

        Article article = new Article("Объявление:", "Ручка от шкафа");
        Article article2 = new Article("Объявление:", "Полка от комода");
        Article article3 = new Article("Объявление:", "Ручка от двери");
        Article article4 = new Article("Объявление:", "Ручка от комода");
        Article article5 = new Article("Объявление:", "Полка от шкафа");

        LinkedList<Searchable> list2 = new LinkedList<>();
        list2.add(tea);
        list2.add(article2);
        list2.add(article5);
        list2.add(article);
        list2.add(wire);
        SearchEngine searchArticle = new SearchEngine(list2);

        System.out.println("searchArticle = " + searchArticle);
        System.out.println(" ");

//        System.out.println("searchArticle.search(\"Ручка\") = " + searchArticle.search("Ручка"));
//        System.out.println(" ");
//
//        System.out.println("searchArticle.search(\"Полка\") = " + searchArticle.search("Полка"));
//        System.out.println(" ");
//
//        System.out.println("searchArticle.search(\"шкафа\") = " + searchArticle.search("шкафа"));
//        System.out.println(" ");

        try {
            SimpleProduct safeMED = new SimpleProduct("SafeMED", -100);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            DiscountedProduct safeMED = new DiscountedProduct("Safe", -3, 15);
        } catch (IllegalArgumentException e) {
            System.out.println((e));
        }
        try {
            DiscountedProduct safeMED = new DiscountedProduct("Snikers", 100, -2);
        } catch (IllegalArgumentException e) {
            System.out.println((e));
        }
        System.out.println(" ");

//        reebokPants = null;// переключать для теста
        SimpleProduct rerere = new SimpleProduct("ReefReekReel", 300);
        LinkedList<Searchable> list3 = new LinkedList<>();
        list3.add(wire);
        list3.add(reebokTapki);
        list3.add(tea);
        list3.add(rerere);
        list3.add(reebokPants);
        SearchEngine searchEngine1 = new SearchEngine(list3);

        try {
            System.out.println("bestResultFound = " + searchEngine1.bestResultFound("Ree"));

        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        basketRandomType.printInfoAboutBasket();
        System.out.println(" ");

        basketRandomType.removeProduct("Чай май");//тут вывод пустого списка
        System.out.println(" ");

        basketRandomType.removeProduct("Чай");

        basketRandomType.printInfoAboutBasket();
        System.out.println(" ");


        basketRandomType.advancedRemoveProduct("Reebok");
        basketRandomType.printInfoAboutBasket();

        System.out.println(" ");
        System.out.println(" -------------- Тут уже мапы пошли -------------- ");
        mapR.printInfoAboutBasket();

        System.out.println(" ");
        System.out.println(" -------------- Общая сумма -------------- ");
        System.out.println("mapNotR.totalSumPriceOfBasket() = " + mapNotR.totalSumPriceOfBasket());

        System.out.println(" ");
        System.out.println(" -------------- mapNotR --------------------------");
        mapNotR.printInfoAboutBasket();

        System.out.println(" ");
        System.out.println(" -------------- проверка --------------------------");
        System.out.println("Результат = " + mapNotR.checkProductInTheBasket("Папа может "));

        System.out.println(" ");
        System.out.println(" -------------- удаление по имени ------------------");
        mapNotR.removeProduct("Папа может ");
        mapNotR.printInfoAboutBasket();

        System.out.println(" ");
        System.out.println(" ------- удаление по имени версия 2.0 ------------------");
        mapNotR.advancedRemoveProduct("Бул");
        System.out.println(" ");
        mapNotR.printInfoAboutBasket();


        System.out.println(" ");
        System.out.println(" -------------- очистка корзины ----------------- ");
        mapNotR.cleanTheBasket();

        System.out.println(" ");
        System.out.println(" ----печать после очистки очистка корзины -------- ");
        mapNotR.printInfoAboutBasket();

        System.out.println(" ");
        mapNotR.addProductInTheBasket(product1);
        mapNotR.addProductInTheBasket(product4);
        mapNotR.addProductInTheBasket(product2);
        mapNotR.addProductInTheBasket(product3);
        mapNotR.addProductInTheBasket(product1);
        mapNotR.addProductInTheBasket(wire);
        mapNotR.addProductInTheBasket(tea);
        mapNotR.addProductInTheBasket(reebokPants);
        mapNotR.addProductInTheBasket(reebokPants);
        mapNotR.addProductInTheBasket(reebokTapki);
        System.out.println("-------добавили продукт и распечатали -------");
        mapNotR.printInfoAboutBasket();


        DiscountedProduct reebokAsher = new DiscountedProduct("Ашер толстовка с молнией Reebok", 2000, 50);
        DiscountedProduct reebokTshort = new DiscountedProduct("Футболка Reebok", 2000, 50);
        DiscountedProduct reebokBootcut = new DiscountedProduct("Женские брюки Reebok", 2000, 50);
        DiscountedProduct reebokGlasses = new DiscountedProduct("Очки Reebok", 3000, 50);
        LinkedList<Searchable> list100 = new LinkedList<>();
        list100.add(wire);
        list100.add(tea);
        list100.add(reebokPants);
        list100.add(reebokPants);
        list100.add(reebokTapki);
        list100.add(reebokAsher);
        list100.add(reebokBootcut);
        list100.add(reebokTshort);
        list100.add(reebokGlasses);

        SearchEngine searchEngine100 = new SearchEngine(list100);
        System.out.println("searchEngine100 = " + searchEngine100);
        System.out.println("searchAndSort = " + searchEngine100.searchAndSort("Reebok"));


    }
}
