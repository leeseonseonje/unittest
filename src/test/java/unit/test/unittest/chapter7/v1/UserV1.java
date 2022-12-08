package unit.test.unittest.chapter7.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static unit.test.unittest.chapter7.v1.UserType.*;

@Getter
@AllArgsConstructor
public class UserV1 {

    private int userId;

    private String email;

    private UserType type;

    public void changeEmail(int userId, String newEmail) {
        UserV1 user = Database.getUserById(userId);

        if (user.email.equals(newEmail)) {
            return;
        }

        CompanyV1 company = Database.getCompany();

        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = emailDomain.equals(company.getCompanyDomainName());

        UserType newType = isEmailCorporate ? EMPLOYEE : CUSTOMER;

        if (type != newType) {
            int data = newType == EMPLOYEE ? 1 : -1;
            int newNumber = company.getNumberOfEmployees() + data;
            Database.saveCompany(newNumber);
        }

        email = newEmail;
        type = newType;
        Database.saveUser(this);
        MessageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
