package ru.evgenyhodz.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.02.2017
 */
public class MyLinkedSetTest {
    private static final int DEFAULT_SIZE = 10;

    @Test
    public void whenAddDuplicateThenItWontBeAddedToLinkedSetTest() {
        MyLinkedSet<String> setList = new MyLinkedSet<>(DEFAULT_SIZE);

        setList.add("First");
        setList.add("Second");
        setList.add("Second");

        Iterator<String> iterator = setList.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());

       // assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenAddNotDuplicatedElementsThenItWillBeAddedToLinkedSetTest() {
        MyLinkedSet<String> setList = new MyLinkedSet<>(DEFAULT_SIZE);

        setList.add("First");
        setList.add("Second");
        setList.add("Third");

        Iterator<String> iterator = setList.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());


    }

}