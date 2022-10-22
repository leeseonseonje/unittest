package unit.test.unittest.chapter4.fragile_test;

import lombok.Getter;

@Getter
public class UserRepository {

    private String lastExecuteSqlStatement;

    public User getById(int id) {
        lastExecuteSqlStatement = "select * from user where user_id = " + id;

        return new User(id, "username");
    }
}
