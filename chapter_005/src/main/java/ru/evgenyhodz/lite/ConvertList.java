package ru.evgenyhodz.lite;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 16.03.2017
 */
public class ConvertList {
    /**
     * Convert 2D array to list.
     *
     * @param array - incoming array.
     * @return - list.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> numbers = new ArrayList<>();
        for (int[] fValue : array) {
            for (int sValue : fValue) {
                numbers.add(sValue);
            }
        }
        return numbers;
    }

    /**
     * Convert List to 2D array with user's number of rows.
     *
     * @param list - incoming list.
     * @param rows - how many rows will be in a new 2D array.
     * @return 2D array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
//        long start = System.nanoTime();
        int resultRows = list.size() / rows;
        if (list.size() % rows != 0) {
            resultRows++;
        }
        int[][] result = new int[resultRows][rows];
        int i = 0;
        int j = 0;
        for (Integer value : list) {
            result[i][j] = value;
            j++;
            if (j > rows - 1) {
                i++;
                j = 0;
            }
        }
//        long end = System.nanoTime();
//        System.out.println(end - start);
        return result;
    }

    /**
     * Используя Guava, интересно было замерить скорость такого подхода.
     * Забегая вперед, скажу что этот подход оказался в 8 раз медленнее
     * чем метод выше.
     *
     * @param list -
     * @param rows -
     * @return -
     */
    public int[][] funToArray(List<Integer> list, int rows) {
        long start = System.nanoTime();
        int[][] result =
                Lists.partition(list, rows)
                        .stream()
                        .map(Ints::toArray)
                        .map(a -> Arrays.copyOf(a, rows))
                        .toArray(int[][]::new);
        long end = System.nanoTime();
        System.out.println(end - start);
        return result;
    }

    public List<Integer> convert(List<int[]> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                result.add(list.get(i)[j]);
            }
        }
        return result;
    }
}
