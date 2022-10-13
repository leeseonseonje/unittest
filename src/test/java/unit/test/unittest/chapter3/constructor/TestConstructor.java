package unit.test.unittest.chapter3.constructor;

import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter2.dependency.Customer;
import unit.test.unittest.chapter2.dependency.Product;
import unit.test.unittest.chapter2.dependency.Store;

import static org.assertj.core.api.Assertions.*;

public class TestConstructor {

    private Store store;
    private Customer sut;

    public TestConstructor() {
        store = Store.addInventory(Product.SHAMPOO, 10);
        sut = new Customer();
    }

    @Test
    void purchaseSucceedsWhenEnoughInventory() {
        boolean success = sut.purchase(store, Product.SHAMPOO, 5);
        assertThat(success).isTrue();
        assertThat(store.getStockQuantity()).isEqualTo(5);
    }

    @Test
    void purchaseFailsWhenNotEnoughInventory() {
        boolean success = sut.purchase(store, Product.SHAMPOO, 15);
        assertThat(success).isFalse();
        assertThat(store.getStockQuantity()).isEqualTo(10);
    }
}
