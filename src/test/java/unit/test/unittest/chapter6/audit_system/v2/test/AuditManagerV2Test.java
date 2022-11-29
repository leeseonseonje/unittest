package unit.test.unittest.chapter6.audit_system.v2.test;

import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter6.audit_system.v2.AuditManagerV2;
import unit.test.unittest.chapter6.audit_system.v2.FileContent;
import unit.test.unittest.chapter6.audit_system.v2.FileUpdate;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AuditManagerV2Test {

    @Test
    void a_new_file_is_created_when_the_current_file_overflows() {
        AuditManagerV2 sut = new AuditManagerV2(3);
        FileContent[] files = new FileContent[]{
                new FileContent(new File("audit_1.txt"), Collections.emptyList()),
                new FileContent(new File("audit_2.txt"), List.of(
                        "Peter; 2019-04-06T16:30:00",
                        "Jane; 2019-04-06T16:40:00",
                        "Jack; 2019-04-06T17:00:00"
                ))
        };

        FileUpdate update = sut.addRecord(files, "Alice",
                LocalDateTime.of(9999, 12, 31, 12, 59));

        assertThat(update.getFileName().getName()).isEqualTo("audit_3.txt");
        assertThat(update.getNewContent()).isEqualTo("Alice;9999-12-31T12:59");
    }


}
