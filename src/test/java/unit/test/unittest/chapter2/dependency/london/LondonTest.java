package unit.test.unittest.chapter2.dependency.london;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        store = Store.addInventory(SHAMPOO, 10);
        BDDMyOngoingStubbing<Boolean> booleanBDDMyOngoingStubbing = given(store.cell(SHAMPOO, 5)).willReturn(true);
        Object mock = booleanBDDMyOngoingStubbing.getMock();
        System.out.println(mock);
//        Customer customer = new Customer();

//        boolean success = customer.purchase(store, SHAMPOO, 5);

//        assertThat(success).isTrue();
    }
}
