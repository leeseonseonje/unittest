package unit.test.unittest.chapter6.audit_system.v2;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ApplicationService {

    private String directoryName;

    private AuditManagerV2 auditManager;

    private Persist persist;

    public void addRecord(String visitorName, LocalDateTime timeOfVisit) {
        FileContent[] files = persist.readDirectory(directoryName);
        FileUpdate update = auditManager.addRecord(files, visitorName, timeOfVisit);
        persist.applyUpdate(directoryName, update);
    }
}
