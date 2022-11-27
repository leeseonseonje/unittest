package unit.test.unittest.chapter6.audit_system.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import unit.test.unittest.chapter6.audit_system.AuditManager;
import unit.test.unittest.chapter6.audit_system.FileSystem;
import unit.test.unittest.chapter6.audit_system.JavaFileSystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.*;

public class AuditManagerTest {
    @Test
    @DisplayName("3줄의 감사정보가 기록되면 다음 파일이 생성된다.")
    void three_line_next_file() throws IOException {
        AuditManager auditManager =
                new AuditManager(1, "/Users/iseonje/unittest_training", new JavaFileSystem());
        auditManager.addRecord("seon", LocalDateTime.now());
    }

    @Test
    void audit_manager_mock() {
        String directoryName = "/Users/iseonje/unittest_training";
        FileSystem mock = mock(FileSystem.class);
        given(mock.getFiles(directoryName)).willReturn(new File[]{
                new File("/Users/iseonje/unittest_training/audit_1.txt"),
                new File("/Users/iseonje/unittest_training/audit_2.txt")
        });
        given(mock.readAllLines(Paths.get("/Users/iseonje/unittest_training/audit_2.txt")))
                .willReturn(
                        List.of("lee;2022-11-28T00:40:05.268732",
                                "seon;2022-11-28T00:40:05.268732",
                                "je;2022-11-28T00:40:05.268732"));

        AuditManager sut = new AuditManager(
                3, directoryName, mock);

        sut.addRecord("human", LocalDateTime.of(9999, 12, 31, 12, 59));

        verify(mock, times(1))
                .write(Paths.get("/Users/iseonje/unittest_training/audit_3.txt"),
                "human;9999-12-31T12:59");
    }

    static class MockFileSystem implements FileSystem {
        @Override
        public File[] getFiles(String directoryName) {
            return new File[]{
                    new File("/Users/iseonje/unittest_training/audit_1.txt"),
                    new File("/Users/iseonje/unittest_training/audit_2.txt")
            };
        }

        @Override
        public void createFile(Path newFile) {
        }

        @Override
        public void write(Path newFile, String newRecord) {
        }

        @Override
        public List<String> readAllLines(Path currentFilePath) {
            return List.of("lee;  2022-11-28T00:40:05.268732",
                    "seon;  2022-11-28T00:40:05.268732",
                    "je;  2022-11-28T00:40:05.268732");
        }
    }

}
