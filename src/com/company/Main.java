package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Item i1=new Item("ana", ItemCondition.NEW, 1, 1);
        Item i2=new Item("kinia", ItemCondition.NEW, 3, 1);
        Item i3=new Item("pies", ItemCondition.NEW, 1, 2);
        FullfillmentCenterContainer c1=new FullfillmentCenterContainer();
        FullfillmentCenter f1=new FullfillmentCenter("nwm", 100);
        f1.addProduct(i1);
        System.err.println("product added... ");
        f1.addProduct(i2);
        System.err.println("product added... ");
        f1.addProduct(i3);
        System.err.println("product added... ");
        c1.addCenter(f1);
        System.err.println("center added... ");
        System.err.println("added center's summary: ");
        c1.summary();
        System.err.println("sorted by quantity: ");
        f1.sortByAmount();
        System.err.println("sorted by names: ");
        f1.sortByName();
    }
}
