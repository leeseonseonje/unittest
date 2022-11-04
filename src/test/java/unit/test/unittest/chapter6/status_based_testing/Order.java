package unit.test.unittest.chapter6.status_based_testing;

import lombok.Getter;
import unit.test.unittest.chapter6.Product;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
}
