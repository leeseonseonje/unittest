package unit.test.unittest.chapter1.coverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
