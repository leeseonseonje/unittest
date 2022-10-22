package unit.test.unittest.chapter4.refactoring_tolerance.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unit.test.unittest.chapter4.refactoring_tolerance.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MessageRendererTest {

    @Test
    @DisplayName("리팩토링 내성이 없는 테스트 최종 결과가 바뀌지 않아도 테스트가 실패 할 수 있음")
    void messageRenderer_uses_correct_sub_renderers() {
        MessageRenderer sut = new MessageRenderer();

        List<IRenderer> renderers = sut.getSubRenderers();

        assertThat(renderers.size()).isEqualTo(3);
        assertThat(renderers.get(0)).isExactlyInstanceOf(HeaderRenderer.class);
        assertThat(renderers.get(1)).isExactlyInstanceOf(BodyRenderer.class);
        assertThat(renderers.get(2)).isExactlyInstanceOf(FooterRenderer.class);
    }

    @Test
    @DisplayName("SUT의 동작에만 신경쓴다. 구현 세부 사항에 결합하지 않는다.")
    void rendering_a_message() {
        MessageRenderer sut = new MessageRenderer();
        Message message = new Message("h", "b", "f");

        String html = sut.render(message);

        Assertions.assertThat(html).isEqualTo("<header>h</header>\n<body>b</body>\n<footer>f</footer>");
    }
}
