package unit.test.unittest.chapter5.mock_stub;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IEmailGateway implements I {

    @Override
    public void sendGreetingEmail(String email) {
      log.info("이메일 발송({})", email);
    }

    @Override
    public int createReport() {
        return 0;
    }
}
