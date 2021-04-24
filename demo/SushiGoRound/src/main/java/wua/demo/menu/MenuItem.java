package wua.demo.menu;

/*
https://stackoverflow.com/questions/2371025/abstract-variables-in-java
 */

public abstract class MenuItem {
    protected String name;
    protected String description;
    protected int price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public MenuItem(String name, String description, int price) {
        if (name == null) throw new NullPointerException("Name may not be null");
        if (price < 0) throw new NullPointerException("price cannot be negative");

        this.name = name;
        this.description = description;
        this.price = price;
    }

    abstract void make() throws InterruptedException;
}


