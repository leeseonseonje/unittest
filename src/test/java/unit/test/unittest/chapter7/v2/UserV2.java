package unit.test.unittest.chapter7.v2;

import lombok.Getter;
import unit.test.unittest.chapter7.UserType;

import static unit.test.unittest.chapter7.UserType.*;

@Getter
public class UserV2 {

    private int userId;

    private String email;

    private UserType type;

    public int changeEmail(String newEmail, String companyDomainName, int numberOfEmployees) {
        if (email.equals(newEmail)) {
            return numberOfEmployees;
        }

        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = emailDomain.equals(companyDomainName);
        UserType newType = isEmailCorporate ? EMPLOYEE : CUSTOMER;

        if (type != newType) {
            int delta = newType == EMPLOYEE ? 1 : -1;
            int newNumber = numberOfEmployees + delta;
            numberOfEmployees = newNumber;
        }

        email = newEmail;
        type = newType;

        return numberOfEmployees;
    }
}
