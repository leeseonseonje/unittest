package unit.test.unittest.chapter6.output_based_testing.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter6.output_based_testing.PriceEngine;
import unit.test.unittest.chapter6.output_based_testing.Product;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class PriceEnginTest {

    @Test
    void discount_of_two_products() {
        Product product1 = new Product("Hand wash");
        Product product2 = new Product("Shampoo");
        PriceEngine sut = new PriceEngine();

        BigDecimal discount = sut.calculateDiscount(product1, product2);

        assertThat(discount).isEqualTo(BigDecimal.valueOf(0.02));
    }
}
