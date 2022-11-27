package unit.test.unittest.chapter6.audit_system;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileSystem {

    File[] getFiles(String directoryName);

    void createFile(Path newFile);
    void write(Path newFile, String newRecord);

    List<String> readAllLines(Path currentFilePath);
}
