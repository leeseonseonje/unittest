package unit.test.unittest.chapter5.mock_stub.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter5.mock_stub.Controller;
import unit.test.unittest.chapter5.mock_stub.IEmailGateway;

import static org.mockito.BDDMockito.*;

public class MockTest {

    @Test
    @DisplayName("목을 생성하여 테스트")
    void sending_a_greetings_email() {
        IEmailGateway mock = mock(IEmailGateway.class);
        Controller sut = new Controller(mock);

        sut.greetUser("user@email.com");
        verify(mock, times(1)).sendGreetingEmail("user@email.com");
    }
}
