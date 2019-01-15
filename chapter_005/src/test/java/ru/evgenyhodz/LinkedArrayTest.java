package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.02.2017
 */
public class LinkedArrayTest {

    private static final int DEF_SIZE = 10;

    /**
     * Checking add(E element) method.
     */
    @Test
    public void whenAddNewObjectToArrayThenItWillBeAddedTest() {
        LinkedArray<String> arr = new LinkedArray<>(DEF_SIZE);
        String string = "Test";

        arr.add(string);
        String result = arr.iterator().next();
        assertThat(result, is("Test"));
    }

    /**
     * Trying to add several elements to list.
     */
    @Test
    public void whenAddMoreThanOneItemToListThenTheYWillBeAddedTest() {
        LinkedArray<String> arr = new LinkedArray<>(DEF_SIZE);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        System.out.println(arr.iterator().next());
        System.out.println(arr.iterator().next());
        System.out.println(arr.iterator().next());
        //  assertThat(result, is("Test"));
    }

//    /**
//     * Checking that list have cycle inside.
//     */
//    @Test
//    public void whenCheckCycleThenItHaveCycleAndReturnsTrue() {
//        LinkedArray<Node> list = new LinkedArray<>(DEF_SIZE);
//
//        boolean result = list.hasCycle(first);
//
//        assertThat(result, is(true));
//    }

}