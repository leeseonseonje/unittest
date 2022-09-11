package unit.test.unittest.chapter2.dependency.london;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unit.test.unittest.chapter2.dependency.Customer;
import unit.test.unittest.chapter2.dependency.Store;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static unit.test.unittest.chapter2.dependency.Product.*;

@ExtendWith(MockitoExtension.class)
public class LondonTest {

    @Mock
    Store store;

    @Test
    void purchaseSucceedsWhenEnoughInventory() {
        given(store.cell(SHAMPOO, 5)).willReturn(true);

        Customer customer = new Customer();
        boolean success = customer.purchase(store, SHAMPOO, 5);

        assertThat(success).isTrue();
        verify(store, times(1)).removeStockQuantity(5);
    }

    @Test
    void purchaseFailsWhenNotEnoughInventory() {
        given(store.cell(SHAMPOO, 5)).willReturn(false);

        Customer customer = new Customer();
        boolean success = customer.purchase(store, SHAMPOO, 5);

        assertThat(success).isFalse();
        verify(store, never()).removeStockQuantity(5);
    }
}
