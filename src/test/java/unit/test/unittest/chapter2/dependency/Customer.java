package unit.test.unittest.chapter2.dependency;

import lombok.Data;

@Data
public class Customer {

    private Store store;

    private Product product;

    private int count;

    public Customer() {
    }

    public boolean purchase(Store store, Product product, int count) {
        return store.cell(product, count);
    }
}
