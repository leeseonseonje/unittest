package unit.test.unittest.chapter6.audit_system;

import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Directory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.*;

@AllArgsConstructor
public class AuditManager {

    private int maxEntriesPerFile;
    private String directoryName;

    private FileSystem fileSystem;

    public void addRecord(String visitorName, LocalDateTime timeOfVisit) {
        File[] filePaths = fileSystem.getFiles(directoryName);
        String newRecord = visitorName + ";" + timeOfVisit;

        if (filePaths.length == 0) {
            Path newFile = Paths.get(directoryName + "/audit_1.txt");
            fileSystem.createFile(newFile);
            fileSystem.write(newFile, newRecord);
            return;
        }

        File[] sorted = sortFileList(filePaths);
        Path currentFilePath = Paths.get(sorted[sorted.length - 1].getAbsolutePath());
        int index = Integer.parseInt(String.valueOf(currentFilePath.getFileName().toString().charAt(6)));
        List<String> lines = fileSystem.readAllLines(currentFilePath);
        if (lines.size() < maxEntriesPerFile) {
            lines.add(newRecord);
            String newContent = String.join("\r\n", lines);
            fileSystem.write(currentFilePath, newContent);
        } else {
            int newIndex = index + 1;
            String newName = "audit_" + newIndex + ".txt";
            Path newFile = Paths.get(directoryName + "/" + newName);
            fileSystem.createFile(newFile);
            fileSystem.write(newFile, newRecord);
        }
    }

    public File[] sortFileList(File[] files) {

        Arrays.sort(files,
                (Comparator<Object>) (object1, object2) -> {
                    String s1 = "";
                    String s2 = "";

                    s1 = ((File) object1).lastModified() + "";
                    s2 = ((File) object2).lastModified() + "";
                    return s1.compareTo(s2);
                });
        return files;
    }
}
