package unit.test.unittest.chapter7.v3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
public class CompanyV3 {

    private String companyDomainName;

    private int numberOfEmployees;

    public void changeNumberOfEmployees(int delta) {

        if (numberOfEmployees + delta >= 0) {
            numberOfEmployees += delta;
        } else {
            throw new IllegalStateException("직원이 없습니다.");
        }
    }

    public boolean isEmailCorporate(String email) {
        String emailDomain = email.split("@")[1];
        return companyDomainName.equals(emailDomain);
    }
}
