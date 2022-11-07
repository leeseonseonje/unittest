package unit.test.unittest.chapter6.status_based_testing.test;

import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter6.Product;
import unit.test.unittest.chapter6.status_based_testing.Order;

import static org.assertj.core.api.Assertions.*;

public class OrderTest {

    @Test
    void adding_a_product_to_an_order() {
        Product product = new Product("Hand wash");
        Order sut = new Order();

        sut.addProduct(product);

        assertThat(sut.getProducts().size()).isEqualTo(1);
        assertThat(sut.getProducts().get(0)).isEqualTo(product);
    }
}
