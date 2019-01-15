package game;

import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 14.11.2017
 */
public class Logger {
    /**
     * List of comments which creating during the game.
     */
    private List<String> comments;

    /**
     * @param list some list (with comments).
     */
    public Logger(List<String> list) {
        this.comments = list;
    }

    /**
     * Adds comment to list.
     *
     * @param action - string description of some unit's action.
     */
    public void addComment(String action) {
        this.comments.add(action);
    }

    /**
     * Gets comments.
     *
     * @return Value of comments.
     */
    public List<String> getComments() {
        return comments;
    }

}
