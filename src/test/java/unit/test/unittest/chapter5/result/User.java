package unit.test.unittest.chapter5.result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    private Long id;

    public String name;

    public String normalizeName(String name) {
        String result = name.trim();

        if (result.length() > 50) {
            return result.substring(0, 50);
        }

        return result;
    }
}
