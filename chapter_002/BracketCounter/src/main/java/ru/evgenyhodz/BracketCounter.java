package ru.evgenyhodz;

/**
 * Class to validate spaced brackets.
 *
 * @author Evgeny Khodzitskiy.
 */
public class BracketCounter {
    /**
     * Validation of spaced brackets in some string.
     *
     * @param string - checked string.
     * @return - true/false.
     */
    public boolean checkBrackets(String string) {
        boolean valid = false;
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                count++;
            } else if (string.charAt(i) == ')') {
                count--;
            }
        }
        if (count == 0) {
            valid = true;
        }
        return valid;
    }
}
