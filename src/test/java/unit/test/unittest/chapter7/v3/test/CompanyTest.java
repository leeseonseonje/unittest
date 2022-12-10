package unit.test.unittest.chapter7.v3.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import unit.test.unittest.chapter7.v3.CompanyV3;

import static org.assertj.core.api.Assertions.*;

public class CompanyTest {

    @ParameterizedTest
    @CsvSource({"'naver.com', 'email@naver.com', true",
                "'naver.com', 'email@email.com', false"})
    void differentiates_a_corporate_email_from_non_corporate(
            String domain, String email, boolean expectedResult
    ) {
        CompanyV3 sut = new CompanyV3(domain, 0);

        boolean emailCorporate = sut.isEmailCorporate(email);

        assertThat(emailCorporate).isEqualTo(expectedResult);
    }
}
