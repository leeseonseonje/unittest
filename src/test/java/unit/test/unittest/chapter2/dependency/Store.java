package unit.test.unittest.chapter2.dependency;

import lombok.Getter;

@Getter
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
            return checkedStockQuantity(count);
        } else {
            return false;
        }
    }

    private boolean checkedStockQuantity(int count) {
        if (this.stockQuantity > count) {
            removeStockQuantity(count);
            return true;
        } else {
            return false;
        }
    }

    private void removeStockQuantity(int count) {
        this.stockQuantity -= count;
    }
}
