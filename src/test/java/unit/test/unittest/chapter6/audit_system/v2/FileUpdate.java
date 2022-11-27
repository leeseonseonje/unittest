package unit.test.unittest.chapter6.audit_system.v2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;

@Getter
@AllArgsConstructor
public class FileUpdate {

    private File fileName;

    private String newContent;
}
