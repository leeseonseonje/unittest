package unit.test.unittest.chapter4.renderer;

public class FooterRenderer implements IRenderer {


    @Override
    public String render(Message message) {
        return "<footer>" + message.getFooter() + "</footer>";
    }
}
