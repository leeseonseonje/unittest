package unit.test.unittest.chapter2.dependency;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Customer {

    private Store store;

    private Product product;

    private int count;

    public boolean purchase(Store store, Product product, int count) {
        if (store.cell(product, count)) {
            store.removeStockQuantity(count);
            return true;
        }
        return false;
    }
}
