package unit.test.unittest.chapter4.fragile_test.test;

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

    @Test
    @DisplayName("구현 세부 사항에 결합되지 않고 코드의 결과값만 신경쓰는 테스트, 리팩토링 하여도 테스트가 실패하지 않는다. " +
            "(리팩토링 내성이 있는 테스트)")
    void getByID_searches_user_of_received_id() {
        UserRepository sut = new UserRepository();

        User user = sut.getById(5);

        assertThat(user.getId()).isEqualTo(5);
    }
}
