package unit.test.unittest.chapter5.mock_stub;

import java.util.Random;

public class IDatabase implements I {

    @Override
    public void sendGreetingEmail(String email) {}

    @Override
    public int createReport() {
        return 10;
    }
}
