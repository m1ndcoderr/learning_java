package game;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.11.2017
 */
public class LoggerTest {
    /**
     * Adding a comment to list.
     */
    @Test
    public void whenAddCommentToListThenCouldGetItFromIt(){
        List<String> list = new ArrayList<>();
        Logger logger = new Logger(list);

        logger.addComment("test");

        assertThat(logger.getComments().get(0), is("test"));
    }

}