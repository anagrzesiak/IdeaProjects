package com.company;

public class Item implements Comparable<Item> {
    String name;
    ItemCondition condition;
    double weight;
    int quantity;
    public Item(String name, ItemCondition condition, double weight, int quantity){
        this.name=name;
        this.condition=condition;
        this.weight=weight;
        this.quantity=quantity;
    }
    public void print(){
        System.out.println("Item's name:" +name);
        System.out.println("Condition: " +condition);
        System.out.println("Weight: " + weight);
        System.out.println("Quantity: " + quantity);
    }

    @Override
    public int compareTo(Item i1) {
        return name.compareTo(i1.name);
    }
}
