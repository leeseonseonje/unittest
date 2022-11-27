package unit.test.unittest.chapter6.audit_system.v2;

import lombok.AllArgsConstructor;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class AuditManagerV2 {

    private int maxEntriesPerFile;

    public FileUpdate addRecord(FileContent[] files, String visitorName, LocalDateTime timeOfVisit) {

        FileContent[] sorted = sortFileList(files);
        String newRecord = visitorName + ";" + timeOfVisit;

        if (sorted.length == 0) {
            return new FileUpdate(new File("audit_1.txt"), newRecord);
        }

        FileContent currentFile = sorted[sorted.length - 1];
        List<String> lines = currentFile.getLines();
        int index = Integer.parseInt(String.valueOf(currentFile.getFileName().toString().charAt(6)));
        if (lines.size() < maxEntriesPerFile) {
            lines.add(newRecord);
            String newContent = String.join("\r\n", lines);
            return new FileUpdate(currentFile.getFileName(), newContent);
        } else {
            int newIndex = index + 1;
            String newName = "audit_" + newIndex + ".txt";
            return new FileUpdate(new File(newName), newRecord);
        }
    }

    public FileContent[] sortFileList(FileContent[] files) {

        Arrays.sort(files,
                (f1, f2) -> {
                    String s1 = "";
                    String s2 = "";

                    s1 = f1.getFileName().lastModified() + "";
                    s2 = f2.getFileName().lastModified() + "";
                    return s1.compareTo(s2);
                });
        return files;
    }
}
