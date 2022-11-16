package ru.gb.lesson3.Api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.lesson3.Service.Product;
import ru.gb.lesson3.Service.Repository;

import java.util.List;
import java.util.Optional;

@Controller
public class productsController {

    @GetMapping("/addProduct")
    @ResponseBody
    public String addProduct(@RequestParam int id, @RequestParam String title, @RequestParam long cost) {
        Repository repository = new Repository();

        if (repository.getProduct(id).getId() == 0) {
            new Product(id, cost, title);
            return "Добавлен товар " + title + " по цене " + cost;
        } else {
            repository.deleteProduct(0);
            return "Товар с таким ID уже существует";
        }
    }

    @GetMapping("/getProduct")
    public String getProduct(@RequestParam int id, Model model) {
        Repository repository = new Repository();
        Product product = repository.getProduct(id);
        model.addAttribute("product", product);

        return "product";
    }

    @GetMapping("/allProducts")
    public String allProducts(Model model) {
        Repository repository = new Repository();
        List<Product> productList = repository.getProducts();
        model.addAttribute("productList", productList);

        return "allProducts";
    }
}
