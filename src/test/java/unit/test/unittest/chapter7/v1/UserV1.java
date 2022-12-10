package unit.test.unittest.chapter7.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import unit.test.unittest.chapter7.Company;
import unit.test.unittest.chapter7.UserType;

import static unit.test.unittest.chapter7.UserType.*;

/**
 * 도메인 계층에서 프로세스 외부 의존성을 의존한다. (지나치게 복잡한 코드)
 */
@Getter
@AllArgsConstructor
public class UserV1 {

    private int userId;

    private String email;

    private UserType type;

    public void changeEmail(int userId, String newEmail) {
        UserV1 user = DatabaseV1.getUserByIdV1(userId);

        if (user.email.equals(newEmail)) {
            return;
        }

        Company company = DatabaseV1.getCompanyV1();

        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = emailDomain.equals(company.getCompanyDomainName());

        UserType newType = isEmailCorporate ? EMPLOYEE : CUSTOMER;

        if (type != newType) {
            int data = newType == EMPLOYEE ? 1 : -1;
            int newNumber = company.getNumberOfEmployees() + data;
            DatabaseV1.saveCompanyV1(newNumber);
        }

        email = newEmail;
        type = newType;
        DatabaseV1.saveUserV1(this);
        MessageBusV1.sendEmailChangedMessage(userId, newEmail);
    }
}
