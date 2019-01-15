package ru.evgenyhodz.set;

import ru.evgenyhodz.LinkedArray;

import java.util.Iterator;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.02.2017
 */
public class MyLinkedSet<E> extends LinkedArray<E> implements CheckDuplication<E> {

    /**
     * Constructor.
     *
     * @param size - size of the container.
     */
    public MyLinkedSet(int size) {
        super(size);
    }

    @Override
    public void add(E value) {
        if (isDuplicate(value)) super.add(value);
    }

    /**
     * Checking if element with such value is already exist in the array.
     *
     * @param value - value to compare with.
     * @return - true/false.
     */
    @Override
    public boolean isDuplicate(E value) {
        boolean result = true;
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (value.equals(iterator.next())) {
                result = false;
                break;
            }
        }
        return result;
    }

//    private int size = 0;
//
//    private Node<E> first;
//
//    private Node<E> last;
//
//    private Node current = first;
//
//    MyLinkedSet(Node<E> prev, E element, Node<E> next) {
//        super(prev, element, next);
//    }
//
//    public void add(E value) {
//    //    if (!isDuplicate(value)) {
//            Node<E> element = new Node<E>(last, value, null);
//            if (last != null) {
//                element.next = element;
//            } else {
//                first = element;
//            }
//            last = element;
//            size++;
//      //  }
//    }
//
//    /**
//     * Returns {@code true} if the iteration has more elements.
//     * (In other words, returns {@code true} if {@link #next} would
//     * return an element rather than throwing an exception.)
//     *
//     * @return {@code true} if the iteration has more elements
//     */
//    @Override
//    public boolean hasNext() {
//        return current != null;
//    }
//
//    /**
//     * Returns the next element in the iteration.
//     *
//     * @return the next element in the iteration
//     * // * @throws NoSuchElementException if the iteration has no more elements
//     */
//    @Override
//    public E next() {
//        E t = (E) current.element;
//        current = current.next;
//        return t;
//    }
//
////    public boolean isDuplicate(R value) {
////        boolean result = false;
////        int index = 0;
////        while (this.objects[index] != null) {
////            index++;
////            if (this.objects[index - 1].equals(value)) {
////                result = true;
////                break;
////            }
////        }
////        return result;
}
