package unit.test.unittest.chapter7;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserType {

    CUSTOMER(1),
    EMPLOYEE(2);

    private int num;
}
