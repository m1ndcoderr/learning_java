package ru.evgenyhodz;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.02.2017
 */
public class MyStackTest {
    // Тест добавления элемента на верхушку стека.
    @Test
    public void push() {
        MyStack<String> stack = new MyStack<>();

        stack.push("test");
        String result = stack.iterator().next();

        assertThat(result, is("test"));

    }

    // Тест удаления элемента из стека.
    @Test
    public void pop() {
        MyStack<String> stack = new MyStack<>();

        stack.push("test");
        stack.pop();

        assertThat(stack.isEmpty(), is(true));
    }

}