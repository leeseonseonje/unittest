package unit.test.unittest.chapter7.v1;

import unit.test.unittest.chapter7.Company;
import unit.test.unittest.chapter7.v1.UserV1;
import unit.test.unittest.chapter7.v2.UserV2;

import java.util.HashMap;
import java.util.Map;

public class DatabaseV1 {

    private static final Map<Integer, UserV1> users = new HashMap<>();
    private static final Company company = new Company("naver.com", 100);

    public static UserV1 getUserByIdV1(int userId) {
        return users.get(userId);
    }

    public static void saveUserV1(UserV1 user) {
        users.put(user.getUserId(), user);
    }

    public static Company getCompanyV1() {
        return company;
    }

    public static void saveCompanyV1(int newNumber) {
        company.setNumberOfEmployees(newNumber);
    }
}
