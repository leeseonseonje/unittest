package unit.test.unittest.chapter4.fragile_test.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter4.fragile_test.User;
import unit.test.unittest.chapter4.fragile_test.UserRepository;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("SQL문을 변경하게되면 결과값이 변하지 않아도 테스트는 실패하게 된다.(깨지기 쉬운 테스트, 리팩토링 내성이 없는 테스트")
    void getById_executes_correct_sql_code() {
        UserRepository sut = new UserRepository();

        User user = sut.getById(5);

        assertThat(sut.getLastExecuteSqlStatement()).isEqualTo("select * from user where user_id = 5");
    }

}
