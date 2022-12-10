package unit.test.unittest.chapter7.v3.test;

import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter7.v3.CompanyV3;
import unit.test.unittest.chapter7.v3.UserV3;

import static org.assertj.core.api.Assertions.*;
import static unit.test.unittest.chapter7.UserType.*;

public class UserTest {

    @Test
    void changing_email_from_non_corporate_to_corporate() {
        CompanyV3 company = new CompanyV3("naver.com", 1);
        UserV3 sut = new UserV3(1, "s@email.com", CUSTOMER);

        sut.changeEmail("seon9323@naver.com", company);

        assertThat(company.getNumberOfEmployees()).isEqualTo(2);
        assertThat(sut.getEmail()).isEqualTo("seon9323@naver.com");
        assertThat(sut.getType()).isEqualTo(EMPLOYEE);
    }
}
