package unit.test.unittest.chapter2.dependency.classical;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter2.dependency.Customer;
import unit.test.unittest.chapter2.dependency.Store;

import static org.assertj.core.api.Assertions.*;
import static unit.test.unittest.chapter2.dependency.Product.*;

public class ClassicalTest {

    @Test
    void PurchaseSucceedsWhenEnoughInventory() {
        Store store = Store.addInventory(SHAMPOO, 10);
        Customer customer = new Customer();

        boolean success = customer.purchase(store, SHAMPOO, 5);

        assertThat(success).isTrue();
        assertThat(store.getStockQuantity()).isEqualTo(5);
    }

    @Test
    void purchaseFailsWhenNotEnoughInventory() {
        Store store = Store.addInventory(SHAMPOO, 10);
        Customer customer = new Customer();

        boolean success = customer.purchase(store, SHAMPOO, 15);

        assertThat(success).isFalse();
        assertThat(store.getStockQuantity()).isEqualTo(10);
    }
}
