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
        Customer sut = new Customer();

        boolean success = sut.purchase(store, SHAMPOO, 5);

        assertThat(success).isTrue();
    }

    @Test
    void purchaseFailsWhenNotEnoughInventory() {
        given(store.cell(SHAMPOO, 5)).willReturn(false);
        Customer sut = new Customer();

        boolean success = sut.purchase(store, SHAMPOO, 5);

        assertThat(success).isFalse();
    }
}
