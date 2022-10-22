package unit.test.unittest.chapter4.renderer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Message {

    private String header;

    private String body;

    private String footer;
}
