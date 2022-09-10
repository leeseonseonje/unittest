package unit.test.unittest.chapter2.dependency;

import lombok.Data;

@Data
public class Store {

    private Product product;

    private int stockQuantity;

    private Store(Product product, int stockQuantity) {
        this.product = product;
        this.stockQuantity = stockQuantity;
    }

    public static Store addInventory(Product product, int stockQuantity) {
        return new Store(product, stockQuantity);
    }

    public boolean cell(Product product, int count) {
        if (this.product == product) {
            return this.checkedStockQuantity(count);
        }
        return false;
    }

    private boolean checkedStockQuantity(int count) {
        if (this.stockQuantity > count) {
            this.stockQuantity -= count;
            return true;
        } else {
            return false;
        }
    }
}
