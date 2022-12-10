package unit.test.unittest.chapter7.v2;

public class MessageBusV2 {

    public void sendEmailChangedMessage(int userId, String newEmail) {
        System.out.println(userId + newEmail + " 전송");
    }
}
