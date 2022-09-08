package unit.test.unittest.chapter1.coverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestCoverage {

    @Test
    void coverage80() {
        assertThat(isStringLong("abc")).isFalse();
    }

    private boolean isStringLong(String input) {
        if (input.length() > 5) {
            return true;
        }
        return false;
    }

    @Test
    void coverage100() {
        assertThat(isStringLongRefactoring("abc")).isFalse();
    }

    private boolean isStringLongRefactoring(String input) {
        return input.length() > 5;
    }
}
