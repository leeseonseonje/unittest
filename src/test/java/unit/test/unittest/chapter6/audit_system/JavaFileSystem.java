package unit.test.unittest.chapter6.audit_system;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.Collections.*;

public class JavaFileSystem implements FileSystem {

    @Override
    public File[] getFiles(String directoryName) {
        File file = new File(directoryName);
        return file.listFiles();
    }

    @Override
    public void createFile(Path newFile) {
        try {
            Files.createFile(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Path newFile, String newRecord) {
        try {
            Files.write(newFile, singleton(newRecord));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readAllLines(Path currentFilePath) {
        try {
            return Files.readAllLines(currentFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emptyList();
    }
}
