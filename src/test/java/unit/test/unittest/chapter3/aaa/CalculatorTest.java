package unit.test.unittest.chapter3.aaa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void sumOfTwoNumber() {
        //준비
        double first = 10;
        double second = 20;
        Calculator calculator = new Calculator();

        //실행
        double result = calculator.sum(first, second);

        assertThat(result).isEqualTo(30);
    }
}
