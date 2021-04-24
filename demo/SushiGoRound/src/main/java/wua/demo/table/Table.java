package wua.demo.table;

import wua.demo.menu.MenuItem;
import wua.demo.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Table {
    private static List<Table> tableList = new ArrayList();  // tracks all tables

    private final int id;
    private Status status;
    private final int capacity;
    private Order order;

    static {
        // For now, create 10 tables, each table sits 4 people
        for (int i=1; i<11; i++) {
            tableList.add(new Table(i, 4));
        }
    }

    public enum Status {
        OCCUPIED,      // 食事中
        UNOCCUPIED,    // 食べ終わった
        OPEN           // 空席
    };

    public Table(int id, int capacity) {
        this.id=id;
        this.status=Status.OPEN;
        this.capacity=capacity;
    }


    public Order getOrder(){
        return this.order;
    }

    public boolean isAvailable(){
        return status==Status.OPEN;
    }

    public Status getStatus() {
        return this.status;
    }

    public int getId(){
        return this.id;
    }

    public boolean canOrder(){
        if (status!=Status.OCCUPIED) System.out.println("Can't order yet. Table is not occupied yet");
        if (order == null) System.out.println("Can't order yet.  Order is null");

        return (status==Status.OCCUPIED && order != null)? true: false;

    }
    public boolean order(MenuItem item) {
        if (canOrder()) return this.order.addItem(item);
        System.out.println("Not ready to order yet");
        return false;
    }

    // occupy a table
    // returns:
    //   true if table is successfully occupied
    //   false if table is already occupied
    public boolean occupy(){
        if (this.status != Status.OPEN) {
            System.out.println(String.format("Cannot occupy table %s.  It is currently occupied. ", this.getId()));
            return false;
        }

        this.status = Status.OCCUPIED;       // occupy this table
        this.order = new Order(this);  // set up a new tab for this table

        System.out.println(String.format("Successfully occupied table %s",this.getId()));
        return true;
    }

    public Table getTableById(int tableId) {
        Optional<Table> result = tableList
                .stream()
                .filter(table -> table.getId()==tableId)  // table ids are unique. Either one match or no match
                .findAny();
        return result.get();
    }

    public static List<Table> list(Table.Status status) {
        return tableList
                .stream()
                .filter(x -> x.getStatus()==status)
                .collect(Collectors.toList());
    }

    public static Table getAnyOpenTable() {
        return list(Table.Status.OPEN).stream().findAny().get();
    }

    public static Table occupyAnyTable() {
        Table table = getAnyOpenTable();
        table.occupy();
        return table;
    }
}
