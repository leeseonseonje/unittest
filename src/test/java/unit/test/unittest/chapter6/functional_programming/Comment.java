package unit.test.unittest.chapter6.functional_programming;

import java.util.ArrayList;
import java.util.List;

public class Comment {

    private String text;

    private List<Comment> comments = new ArrayList<>();

    public Comment(String text) {
        this.text = text;
    }

    public Comment addComment(String text) {
        Comment comment = new Comment(text);
        comment.comments.add(comment);
        return comment;
    }
}
