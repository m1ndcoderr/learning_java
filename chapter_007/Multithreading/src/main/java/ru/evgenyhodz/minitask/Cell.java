package ru.evgenyhodz.minitask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.04.2017
 */
public class Cell {
    /**
     * Reference to lock.
     */
    private ReentrantLock reentrantLock;

    /**
     * Constructor.
     *
     * @param reentrantLock - reentrantLock.
     */
    public Cell(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    /**
     * Getter.
     *
     * @return reentrantLock.
     */
    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }
}
