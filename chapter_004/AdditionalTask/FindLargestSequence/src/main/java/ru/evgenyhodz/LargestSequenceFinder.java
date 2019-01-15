package ru.evgenyhodz;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * Class with algorithm of finding the longest sequence of numbers in one-dimensional array.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.01.2017
 */
public class LargestSequenceFinder {
    /**
     * Returns string value with the longest sequence of numbers from the array of numbers.
     *
     * @param numbers - one-dimensional array with int values.
     * @return - string value with the longest sequence of numbers.
     * @throws ArrayIndexOutOfBoundsException - exception, if input array is empty.
     */
    public String findLargestSequence(int[] numbers) throws ArrayIndexOutOfBoundsException {
        int bestStart = 0;
        int curStart = 0;
        int bestLength = 1;
        int curLength = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                curLength++;
                if (curLength > bestLength) {
                    bestStart = curStart;
                    bestLength = curLength;
                }
            } else {
                curStart = i;
                curLength = 1;
            }
        }
        List<String> identical = new ArrayList<>();
        for (int i = 0; i < bestLength; i++) {
            identical.add(String.valueOf(numbers[bestStart + i]));
        }
        return Joiner.on(", ").join(identical);
    }
}
