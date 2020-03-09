package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FullfillmentCenter {
    public int totalWeight;
    public int totalQuantity;
    public String centerName;
    public List<Item> itemsList=new ArrayList();
    public double maxWeight;
    public FullfillmentCenter(String centerName, double maxWeight){
        this.maxWeight=maxWeight;
        this.centerName=centerName;
    }
    public void addProduct(Item i1) {
        if (totalWeight + i1.weight <= maxWeight) {
                int size=itemsList.size();
                boolean ans=itemsList.contains(i1.name);
                if(ans){
                for(int i=0; i<size; i++) {
                    Item i_ = itemsList.get(i);
                    if (i_.name == i1.name) {
                        totalWeight += i1.weight;
                        totalQuantity++;
                        (i_.quantity)++;
                        break;
                    }
                }
            }
            else
                itemsList.add(new Item(i1.name, i1.condition, i1.weight, i1.quantity));
                totalWeight+=i1.weight;
        } else
            System.err.println("Maximum weight exceeded");
    };

    public void getProduct(Item i1){
        if(i1.quantity==1){
            itemsList.remove(i1);
            totalWeight-=i1.weight;
            totalQuantity--;
        }
        else {
            (i1.quantity)--;
            totalWeight -= i1.weight;
            totalQuantity--;
        }
    };
    public void removeProduct(Item i1){
        itemsList.remove(i1);
        totalWeight-=i1.weight;
        totalQuantity--;
    };
    public Item search(String name){
        int size=itemsList.size();
        for(int i=0; i<size; i++){
            Item i_=itemsList.get(i);
            if(i_.name==name){
                return i_;
            }
        }
        return null;
    };
    public List searchPartial(String name){
        List<Item> foundItems=new ArrayList();
        int size=itemsList.size();
        for(int i=0; i<size; i++){
            Item i_=itemsList.get(i);
            if(i_.name.contains(name)){
                foundItems.add(new Item(i_.name, i_.condition, i_.weight, i_.quantity));
            }
        }
        return foundItems;
    };
    public int countByCondition(ItemCondition condition){
        int counted=0;
        int size=itemsList.size();
        for(int i=0; i<size; i++){
            Item i_=itemsList.get(i);
            if(i_.condition==condition){
                counted++;
            }
        }
        return counted;
    };
    public void summary(){
        int size=itemsList.size();
        for(int i=0; i<size; i++){
            Item i_=itemsList.get(i);
            i_.print();
        }
    };
    public void sortByName(){
        Collections.sort(itemsList, Comparator.comparing(a -> a.name));
        int size=itemsList.size();
        for(int i=0; i<size; i++){
            Item i_=itemsList.get(i);
            i_.print();
        }
    };
    public void sortByAmount(){
        Collections.sort(itemsList, new ItemNameComparator().reversed());
        for(Item item : itemsList) {
            item.print();
        }
    };
    public Item max() {
       return Collections.max(itemsList, Comparator.comparing(s -> s.quantity));
    }
}
