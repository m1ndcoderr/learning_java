package ru.evgenyhodz.tree;

import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 28.02.2017
 */
public interface TreeElement<E> {

    /**
     * Adding a new element to container.
     *
     * @param element element to add.
     */
    void addChild(E element);

    /**
     * Gets all children of tree.
     *
     * @return all children in a List.
     */
    List<E> getChildren();

    /**
     * Finds element in container.
     *
     * @param element element to find.
     * @return founded element.
     */
    E find(E element);
}
