package unit.test.unittest.chapter7.v3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import unit.test.unittest.chapter7.UserType;

import static unit.test.unittest.chapter7.UserType.CUSTOMER;
import static unit.test.unittest.chapter7.UserType.EMPLOYEE;

@Getter
@AllArgsConstructor
public class UserV3 {

    private int userId;

    private String email;

    private UserType type;

    public void changeEmail(String newEmail, CompanyV3 company) {
        if (email.equals(newEmail)) {
            return;
        }

        UserType newType = company.isEmailCorporate(newEmail) ? EMPLOYEE : CUSTOMER;

        if (type != newType) {
            int delta = newType == EMPLOYEE ? 1 : -1;
            company.changeNumberOfEmployees(delta);
        }

        email = newEmail;
        type = newType;
    }
}
