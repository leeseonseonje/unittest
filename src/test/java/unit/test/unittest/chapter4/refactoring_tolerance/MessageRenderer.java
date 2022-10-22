package unit.test.unittest.chapter4.refactoring_tolerance;

import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.*;

@Getter
public class MessageRenderer implements IRenderer {

    private List<IRenderer> subRenderers;

    public MessageRenderer() {
        subRenderers = List.of(new HeaderRenderer(), new BodyRenderer(), new FooterRenderer());
    }

    @Override
    public String render(Message message) {
        return subRenderers.stream().map(r -> r.render(message)).collect(joining("\n"));
    }
}
