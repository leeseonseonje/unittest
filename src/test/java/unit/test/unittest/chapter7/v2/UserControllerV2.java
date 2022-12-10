package unit.test.unittest.chapter7.v2;

import unit.test.unittest.chapter7.Company;

/**
 * 의존성을 외부에서 주입받지 않고, 직접 인스턴스화 한다.
 * user.changeEmail은 업데이트된 적원 수 반환 -> 회사 직원 수는 user와 관련이 없다. 이 책임은 다른 곳에 있어야 한다.
 */
public class UserControllerV2 {

    private final DatabaseV2 database = new DatabaseV2();
    private final MessageBusV2 messageBus = new MessageBusV2();

    public void changeEmail(int userId, String newEmail) {
        UserV2 user = database.getUserById(userId);

        Company company = database.getCompany();

        int newNumberOfEmployees = user.changeEmail(
                newEmail,
                company.getCompanyDomainName(),
                company.getNumberOfEmployees()
        );

        database.saveCompany(newNumberOfEmployees);
        database.saveUser(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
