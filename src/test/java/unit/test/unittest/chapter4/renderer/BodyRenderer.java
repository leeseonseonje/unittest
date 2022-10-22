package unit.test.unittest.chapter4.renderer;

public class BodyRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return "<body>" + message.getBody() + "</body>";
    }
}
