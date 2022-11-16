package ru.gb.lesson3.Service;

public class Product {
    private int id;
    private String title;
    private long cost;

    public Product(int id, long cost, String title) {
        this.id = id;
        this.cost = cost;
        this.title = title;

        addToList();
    }

    private void addToList() {
        Repository repository = new Repository();
        repository.addProducts(this);
    }

    public long getId() {
        return id;
    }

    public long getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }
}
