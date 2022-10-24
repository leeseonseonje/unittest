package unit.test.unittest.chapter5.mock_stub.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter5.mock_stub.Controller;
import unit.test.unittest.chapter5.mock_stub.IDatabase;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

public class StubTest {

    @Test
    @DisplayName("깨지기 쉬운 테스트(과잉명세: 스텁을 검증하여 구현 세부 사항에 의존)")
    void creating_a_report() {
        IDatabase stub = mock(IDatabase.class);
        given(stub.createReport()).willReturn(10);
        Controller sut = new Controller(stub);

        int report = sut.createReport();

        assertThat(report).isEqualTo(10);
        verify(stub, times(1)).createReport(); // 과잉 명세
    }
}
