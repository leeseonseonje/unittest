package unit.test.unittest.chapter7.v1;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private static final Map<Integer, UserV1> users = new HashMap<>();
    private static final CompanyV1 company = new CompanyV1("naver.com", 100);

    public static UserV1 getUserById(int userId) {
        return users.get(userId);
    }

    public static void saveUser(UserV1 user) {
        users.put(user.getUserId(), user);
    }

    public static CompanyV1 getCompany() {
        return company;
    }

    public static void saveCompany(int newNumber) {
        company.setNumberOfEmployees(newNumber);
    }
}
