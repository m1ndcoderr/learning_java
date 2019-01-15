package ru.evgenyhodz.map.directory;

/**
 * @param <A> - key.
 * @param <B> - value.
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.02.2017
 */
public class Node<A, B> implements Element<A, B> {
    /**
     * Key.
     */
    private A key;
    /**
     * Value.
     */
    private B value;

    public Node(A key, B value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns key.
     *
     * @return key.
     */
    @Override
    public A getKey() {
        return this.key;
    }

    /**
     * Returns value.
     *
     * @return value.
     */
    @Override
    public B getValue() {
        return this.value;
    }
}
