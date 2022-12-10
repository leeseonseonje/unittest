package unit.test.unittest.chapter7.v3;

import unit.test.unittest.chapter7.Company;

import java.util.HashMap;
import java.util.Map;

public class DatabaseV3 {

    private static final Map<Integer, UserV3> users = new HashMap<>();
    private static final CompanyV3 company = new CompanyV3("naver.com", 100);

    public UserV3 getUserById(int userId) {
        return users.get(userId);
    }

    public void saveUser(UserV3 user) {
        users.put(user.getUserId(), user);
    }

    public CompanyV3 getCompany() {
        return company;
    }

    public void saveCompany(int newNumber) {
        company.setNumberOfEmployees(newNumber);
    }
}
