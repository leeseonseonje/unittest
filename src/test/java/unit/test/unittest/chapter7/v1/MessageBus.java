package unit.test.unittest.chapter7.v1;

public class MessageBus {

    public static void sendEmailChangedMessage(int userId, String newEmail) {
        System.out.println(userId + newEmail + " 전송");
    }
}
