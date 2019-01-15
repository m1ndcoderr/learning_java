package evgenyhodz;

/**
 * Class that reverse sentences and phrases, for example:
 * if we have: "John have troubles", after we'll have:
 * "troubles have John".
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.12.2016
 */
public class ReverseSentence {
    /**
     * Method reverse sentences.
     *
     * @param sentence - string value, which has words and spaces.
     * @return changed reversed sentence.
     */
    public String revSentence(String sentence) {
        StringBuilder sb = new StringBuilder(sentence.length() + 1);
        String[] words = sentence.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
