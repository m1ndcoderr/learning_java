package ru.evgenyhodz.lite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.03.2017
 */
public class SortUserTest {
    /**
     *
     */
    @Test
    public void sort() {
        User a = new User("Vasya", 1);
        User b = new User("Petya", 2);
        User c = new User("Ivan", 3);
        List<User> list = new ArrayList<>();
        list.add(c);
        list.add(a);
        list.add(b);

        for (User user : list) {
            System.out.print(user.getAge());
        }

        System.out.print("\n");

        SortUser sortUser = new SortUser();
        Set<User> set = sortUser.sort(list);

        for (User user : set) {
            System.out.print(user.getAge());
        }

        int result = set.iterator().next().getAge();
        assertThat(result, is(1));
    }

    /**
     * Trying to check sorting by hash code...
     */
    @Test
    public void whenSortedByHashThenGetSortedByHash(){
        User a = new User("Vladimir", 1);
        User b = new User("Kostya", 2);
        User c = new User("Ivan", 3);
        List<User> list = new ArrayList<>();
        list.add(c);
        list.add(a);
        list.add(b);

        SortUser su = new SortUser();
        su.sortHash(list);
        // Не понял, что я тут должен ожидать на выходе?
    }

    /**
     * Check sorting by name length.
     */
    @Test
    public void whenSortedByNameLength(){
        User a = new User("Vladimir", 1);
        User b = new User("Kostya", 2);
        User c = new User("Ivan", 3);
        List<User> list = new ArrayList<>();
        list.add(a);
        list.add(c);
        list.add(b);

        SortUser su = new SortUser();
        List<User> result =  su.sortLength(list);

        assertThat(result.get(0).getName(), is("Ivan"));
        assertThat(result.get(1).getName(), is("Kostya"));
        assertThat(result.get(2).getName(), is("Vladimir"));
    }

}