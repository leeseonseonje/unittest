package unit.test.unittest.chapter1.coverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class QuarterCoverage {


    @Test
    void coverage50() {
        assertThat(isStringLong("abc")).isFalse();
    }

    @Test
    void coverage100() {
        assertThat(isStringLong("abcde")).isFalse();
        assertThat(isStringLong("abcdef")).isTrue();
    }

    private boolean isStringLong(String input) {
        return input.length() > 5;
    }

    @Test
    void test() {
        int result = parseInt("5");
        assertThat(result).isEqualTo(5);
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
