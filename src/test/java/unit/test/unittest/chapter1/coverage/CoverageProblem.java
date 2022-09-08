package unit.test.unittest.chapter1.coverage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CoverageProblem {

    private boolean wasLastStringLong;

    @Test
    void test() {
        assertThat(isStringLong("abc")).isFalse();
    }

    private boolean isStringLong(String input) {
        boolean result = input.length() > 5;
        wasLastStringLong = result;
        return result;
    }
}
