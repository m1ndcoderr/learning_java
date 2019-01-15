package ru.evgenyhodz;

import java.util.Iterator;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.02.2017
 */
public class MyStack<T> {

    private Node first;

    private int num;

    private class Node {
        T t;
        Node next;
    }

    public boolean isEmpty() {
        return first == null || num == 0;
    }

    public int size() {
        return num;
    }

    // Кладем элемент на верхушку стека.
    public void push(T element) {
        Node old = first;
        first = new Node();
        first.t = element;
        first.next = old;
        num++;
    }

    // Удаление элемента с верхушки стека.
    public T pop() {
        T t = first.t;
        first = first.next;
        num--;
        return t;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = (T) current.t;
            current = current.next;
            return t;
        }
    }

}
