package unit.test.unittest.chapter6.audit_system.v2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class Persist {

    public FileContent[] readDirectory(String directoryName) {
        File file = new File(directoryName);
        File[] files = file.listFiles();
        List<FileContent> fileContents = Arrays.stream(files).map(e -> {
            try {
                return new FileContent(e, Files.readAllLines(Paths.get(e.getAbsolutePath())));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }).collect(toList());

        FileContent[] result = new FileContent[fileContents.size()];
        for (int i = 0; i < fileContents.size(); i++) {
            result[i] = new FileContent(fileContents.get(i).getFileName(), fileContents.get(i).getLines());
        }
        return result;
    }

    public void applyUpdate(String directoryName, FileUpdate fileUpdate) {
        Path path = Paths.get(directoryName + fileUpdate.getFileName().getAbsolutePath());
        try {
            Files.write(path, singleton(fileUpdate.getNewContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
