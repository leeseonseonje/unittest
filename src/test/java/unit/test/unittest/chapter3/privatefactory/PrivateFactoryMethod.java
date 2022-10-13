package unit.test.unittest.chapter3.privatefactory;

import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter2.dependency.Customer;
import unit.test.unittest.chapter2.dependency.Product;
import unit.test.unittest.chapter2.dependency.Store;

import static org.assertj.core.api.Assertions.assertThat;

public class PrivateFactoryMethod {


    @Test
    void purchaseSucceedsWhenEnoughInventory() {
        Store store = createStoreWithInventory(Product.SHAMPOO, 10);
        Customer sut = createCustomer();
        boolean success = sut.purchase(store, Product.SHAMPOO, 5);
        assertThat(success).isTrue();
        assertThat(store.getStockQuantity()).isEqualTo(5);
    }

    @Test
    void purchaseFailsWhenNotEnoughInventory() {
        Store store = createStoreWithInventory(Product.SHAMPOO, 10);
        Customer sut = createCustomer();
        boolean success = sut.purchase(store, Product.SHAMPOO, 15);
        assertThat(success).isFalse();
        assertThat(store.getStockQuantity()).isEqualTo(10);
    }

    private Store createStoreWithInventory(Product product, int quantity) {
        return Store.addInventory(product, quantity);
    }

    private Customer createCustomer() {
        return new Customer();
    }
}
