package unit.test.unittest.chapter5.result;

import java.util.HashMap;
import java.util.Map;

public class UserController {

    private static final Map<Long, User> users = new HashMap<>();

    public void RenameUser(Long userId, String newName) {

        User user = users.get(userId);

        user.name = user.normalizeName(newName);
    }
}
