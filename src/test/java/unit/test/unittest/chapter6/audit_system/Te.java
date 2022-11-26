package unit.test.unittest.chapter6.audit_system;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

public class Te {
    @Test
    void test() throws IOException {
        AuditManager auditManager =
                new AuditManager(3, "/Users/iseonje/unittest_training");
        auditManager.addRecord("tjswp", LocalDateTime.now());
    }
}
