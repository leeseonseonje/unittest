package unit.test.unittest.chapter4.refactoring_tolerance;

public class HeaderRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return "<header>" + message.getHeader() + "</header>";
    }
}
