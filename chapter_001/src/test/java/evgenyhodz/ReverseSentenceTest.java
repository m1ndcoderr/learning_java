package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.12.2016
 */
public class ReverseSentenceTest {
    /**
     * Checking method that reverse the sentence.
     */
    @Test
    public void revSentence() {
        ReverseSentence reverseSentence = new ReverseSentence();
        String sentence = "word1 word2 word3 word4 word5";
        String check = "word5 word4 word3 word2 word1";
        assertThat(reverseSentence.revSentence(sentence), is(check));
    }
}