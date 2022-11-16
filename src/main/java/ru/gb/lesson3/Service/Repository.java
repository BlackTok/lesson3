package ru.gb.lesson3.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository {
    private static final List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products; // change
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public Product getProduct(int id) {
        Optional<Product> product = this.products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (product.isPresent()) {
            return product.get();
        } else {
            return new Product(0, 0, "0");
        }
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id)
                products.remove(i);
            break;
        }
    }
}
