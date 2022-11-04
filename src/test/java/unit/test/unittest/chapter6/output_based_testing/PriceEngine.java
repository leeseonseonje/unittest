package unit.test.unittest.chapter6.output_based_testing;


import java.math.BigDecimal;

public class PriceEngine {

    public BigDecimal calculateDiscount(Product ...products) {
        BigDecimal discount = BigDecimal.valueOf(products.length * 0.01);
        return discount.min(BigDecimal.valueOf(0.2));
    }
}
