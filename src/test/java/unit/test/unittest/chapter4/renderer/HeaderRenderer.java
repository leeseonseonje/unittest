package unit.test.unittest.chapter4.renderer;

public class HeaderRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return "<header>" + message.getHeader() + "</header>";
    }
}
