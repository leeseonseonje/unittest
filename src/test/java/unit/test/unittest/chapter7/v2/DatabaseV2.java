package unit.test.unittest.chapter7.v2;

import unit.test.unittest.chapter7.Company;
import unit.test.unittest.chapter7.v1.UserV1;

import java.util.HashMap;
import java.util.Map;

public class DatabaseV2 {

    private static final Map<Integer, UserV2> users = new HashMap<>();
    private static final Company company = new Company("naver.com", 100);

    public UserV2 getUserById(int userId) {
        return users.get(userId);
    }

    public void saveUser(UserV2 user) {
        users.put(user.getUserId(), user);
    }

    public Company getCompany() {
        return company;
    }

    public void saveCompany(int newNumber) {
        company.setNumberOfEmployees(newNumber);
    }
}
