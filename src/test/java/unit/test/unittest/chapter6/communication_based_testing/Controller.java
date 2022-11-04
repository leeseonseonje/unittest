package unit.test.unittest.chapter6.communication_based_testing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Controller {

    private EmailGateway emailGateway;

    public void greetUser(String email) {
        emailGateway.sendGreetingEmail(email);
    }
}
