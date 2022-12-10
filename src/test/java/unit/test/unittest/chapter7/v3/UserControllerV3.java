package unit.test.unittest.chapter7.v3;

import unit.test.unittest.chapter7.Company;
import unit.test.unittest.chapter7.v2.DatabaseV2;
import unit.test.unittest.chapter7.v2.MessageBusV2;
import unit.test.unittest.chapter7.v2.UserV2;

/**
 * 의존성을 외부에서 주입받지 않고, 직접 인스턴스화 한다.
 * user.changeEmail은 업데이트된 적원 수 반환 -> 회사 직원 수는 user와 관련이 없다. 이 책임은 다른 곳에 있어야 한다.
 */
public class UserControllerV3 {

    private final DatabaseV3 database = new DatabaseV3();
    private final MessageBusV2 messageBus = new MessageBusV2();

    public void changeEmail(int userId, String newEmail) {
        UserV3 user = database.getUserById(userId);

        CompanyV3 company = database.getCompany();

        user.changeEmail(newEmail, company);

        database.saveCompany(company.getNumberOfEmployees());
        database.saveUser(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
