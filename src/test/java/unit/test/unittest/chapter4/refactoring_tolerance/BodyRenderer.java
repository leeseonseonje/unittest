package unit.test.unittest.chapter4.refactoring_tolerance;

public class BodyRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return "<body>" + message.getBody() + "</body>";
    }
}
