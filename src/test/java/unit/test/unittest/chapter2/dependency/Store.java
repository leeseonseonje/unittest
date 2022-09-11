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
        }
        return false;
    }

    private boolean checkedStockQuantity(int count) {
        return stockQuantity > count;
    }

    public void removeStockQuantity(int count) {
        this.stockQuantity -= count;
    }
}
