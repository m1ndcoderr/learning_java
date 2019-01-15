package ru.evgenyhodz.lite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 16.03.2017
 */
public class ConvertListTest {
    @Test
    public void whenGetNumbersFrom2DArrayThenGetNumbersListTest() {
        int[][] array = {{1, 2}, {3, 4}};
        ConvertList conv = new ConvertList();
        List<Integer> result = conv.toList(array);
        assertThat(result.size(), is(4));
        // Можно раскомитить и убедиться в верной работе метода.
        for (Integer num : result) {
            System.out.println(num);
        }
    }

    @Test
    public void whenWeConvertListThenGet2DArrayTest() {
        List<Integer> list = new ArrayList<>(7);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        ConvertList convertList = new ConvertList();
        int[][] a = convertList.toArray(list, 2);
        int[][] b = convertList.toArray(list, 3);
        int[][] c = convertList.toArray(list, 4);

        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));
        System.out.println(Arrays.deepToString(c));

        // Интересно было замерить скорость метода,
        // использующего Stream и Guava.

        int[][] g = convertList.funToArray(list, 2);
        int[][] h = convertList.funToArray(list, 3);
        int[][] j = convertList.funToArray(list, 4);

        System.out.println(Arrays.deepToString(g));
        System.out.println(Arrays.deepToString(h));
        System.out.println(Arrays.deepToString(j));
    }

    @Test
    public void whenGetAllValuesFromAllArraysInListWhenReturnOneListWithAllValuesTest() {
        ConvertList convertList = new ConvertList();
        List<int[]> test = new ArrayList<>();
        int[] a = {1, 2};
        int[] b = {3, 4, 5, 6};
        test.add(a);
        test.add(b);
        List<Integer> result = convertList.convert(test);
        assertThat(result.size(), is(6));

        for (Integer value : result) {
            System.out.print(value);
        }
    }

}