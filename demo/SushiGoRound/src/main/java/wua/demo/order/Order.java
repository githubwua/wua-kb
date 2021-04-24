package wua.demo.order;

import wua.demo.menu.*;
import wua.demo.table.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    static List<Order> orderList = new ArrayList<>();  // List of orders
    static int counter=0;
    int id;
    Table table;
    List<MenuItem> items = new ArrayList<>();

    enum Status {
        OPEN,
        CLOSE
    };

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public Table getTable() {
        return table;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public Order(Table table){
        this.id=++counter;
        this.table=table;
        orderList.add(this);  // add this order to orderlist
    }

    public boolean addItem(MenuItem item){
        return items.add(item);
    }

    public static void main(String[] args) {

    }
}

