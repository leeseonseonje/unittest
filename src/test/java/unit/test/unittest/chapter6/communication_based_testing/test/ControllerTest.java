package unit.test.unittest.chapter6.communication_based_testing.test;

import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter6.communication_based_testing.Controller;
import unit.test.unittest.chapter6.communication_based_testing.EmailGateway;

import static org.mockito.BDDMockito.*;

public class ControllerTest {

    @Test
    void sending_a_greeting_email() {
        EmailGateway emailGatewayMock = mock(EmailGateway.class);
        Controller sut = new Controller(emailGatewayMock);

        sut.greetUser("user@email.com");

        verify(emailGatewayMock, times(1)).sendGreetingEmail("user@email.com");
    }
}
