package ru.geekbrains.spring.one.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Book", 25),
                new Product(2L, "Magasine", 15),
                new Product(3L, "Table", 125),
                new Product(4L, "Plate", 35)
        ));
    }

    public List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        products.add(product);
    }

    public Optional<Product> findOneById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }
}
