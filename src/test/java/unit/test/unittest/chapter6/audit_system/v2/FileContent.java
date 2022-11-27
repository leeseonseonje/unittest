package unit.test.unittest.chapter6.audit_system.v2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.util.List;

@Getter
@AllArgsConstructor
public class FileContent {

    private File fileName;

    private List<String> lines;
}
