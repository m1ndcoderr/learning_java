package ru.evgenyhodz.wn;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.03.2017
 */
public class Lock {
    /**
     * Lock object
     */
    private final Object lock = new Object();
    /**
     * Boolean flag
     */
    private boolean condition = false;

    /**
     * Lock smth
     */
    public void lockObject() {
        synchronized (this.lock) {
            while (condition) {
                try {
                    lock.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            this.condition = true;
        }
    }

    /**
     * Unlock smth
     */
    public void unlockObject() {
        synchronized (this.lock) {
            this.condition = false;
            this.lock.notify();
        }
    }
}
