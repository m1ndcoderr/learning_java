package ru.evgenyhodz.tree;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 05.03.2017
 */
public class MyTreeTest {

    private MyTree<Integer> tree;

    private static final int CHILDREN = 3;

    private static final int EXPECTED = 123;


    @Test
    public void addChild() throws Exception {
        tree = new MyTree<>(CHILDREN);
        tree.addChild(EXPECTED);
        List<Integer> result = tree.getChildren();
        assertThat(EXPECTED, is(result.get(0)));
    }

    @Test
    public void getChildren() throws Exception {
        tree = new MyTree<>(CHILDREN);
        tree.addChild(EXPECTED);
        List<Integer> result = tree.getChildren();
        assertThat(result.get(0), is(EXPECTED));
    }

    @Test
    public void find() throws Exception {
        tree = new MyTree<>(CHILDREN);
        tree.addChild(EXPECTED);
        int result = tree.find(123);
        assertEquals(result, EXPECTED);
    }

}