package ru.evgenyhodz.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.02.2017
 */
public class MyTree<E> implements TreeElement<E> {

    private Node<E> rootNode;

    private int childrenCount;

    private static final int DEFAULT_NUMBER_OF_CHILDREN = 2;

    public MyTree() {
        this(DEFAULT_NUMBER_OF_CHILDREN);
    }

    public MyTree(int defaultNumberOfChildren) {
        this.rootNode = null;
        this.childrenCount = defaultNumberOfChildren;
    }


    /**
     * Adding a new element to container.
     *
     * @param element element to add.
     */
    @Override
    public void addChild(E element) {
        if (element != null) {
            if (rootNode == null) {
                rootNode = new Node<>(element, childrenCount);
            } else {
                rootNode.addChild(element);
            }
        }
    }

    /**
     * Gets all children of tree.
     *
     * @return all children in a List.
     */
    @Override
    public List<E> getChildren() {
        List<E> result;
        if (this.rootNode != null) {
            result = rootNode.getChildren();
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Finds element in container.
     *
     * @param element element to find.
     * @return founded element.
     */
    @Override
    public E find(E element) {
        E result = null;
        if (element != null && rootNode != null) {
            result = rootNode.find(element);
        }
        return result;
    }

    private class Node<E> implements TreeElement<E> {

        private E value;

        private int index, childrenCount;

        private List<Node<E>> child;

        public Node(E e) {
            this(e, DEFAULT_NUMBER_OF_CHILDREN);
        }

        Node(E value, int childrenCount) {
            this.value = value;
            this.childrenCount = childrenCount;
            this.index = 0;
            this.child = new ArrayList<>();
        }

        /**
         * Adding a new element to container.
         *
         * @param element element to add.
         */
        @Override
        public void addChild(E element) {
            if (child.size() == childrenCount) {
                child.get(index++).addChild(element);
                index = index % childrenCount;
            } else {
                // ???? Что за unchecked assignment  ???
                child.add(new Node(element));
            }
        }

        /**
         * Gets all children of tree.
         *
         * @return all children in a List.
         */
        @Override
        public List<E> getChildren() {
            List<E> result = new ArrayList<E>();
            result.add(value);
            for (Node<E> node : child) {
                result.addAll(node.getChildren());
            }
            return result;
        }

        /**
         * Finds element in container.
         *
         * @param element element to find.
         * @return founded element.
         */
        @Override
        public E find(E element) {
            E result = null;
            if (!element.equals(value)) {
                for (Node<E> node : child) {
                    result = node.find(element);
                    if (result != null) {
                        break;
                    }
                }
            } else {
                result = value;
            }
            return result;
        }
    }
}
