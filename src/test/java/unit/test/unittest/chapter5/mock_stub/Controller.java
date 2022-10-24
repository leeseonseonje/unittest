package unit.test.unittest.chapter5.mock_stub;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Controller {

    private I i;

    public void greetUser(String email) {
        i.sendGreetingEmail(email);
    }

    public int createReport() {
        return i.createReport();
    }
}
