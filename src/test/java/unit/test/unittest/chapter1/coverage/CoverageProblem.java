package unit.test.unittest.chapter1.coverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CoverageProblem {

    @Test
    void test() {
        assertThat(isStringLong("abc")).isFalse();
    }

    private boolean isStringLong(String input) {
        return input.length() > 5;
    }
}
