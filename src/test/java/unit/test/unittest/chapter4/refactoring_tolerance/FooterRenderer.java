package unit.test.unittest.chapter4.refactoring_tolerance;

public class FooterRenderer implements IRenderer {


    @Override
    public String render(Message message) {
        return "<footer>" + message.getFooter() + "</footer>";
    }
}
