package ru.evgenyhodz.jmm;

/**
 * Example to demonstrate some problem with thread stacks.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.03.2017
 */
public class Demonstration extends Thread {
    /**
     * Some value to operate with.
     */
    private int value;
    /**
     * Boolean variable.
     */
    private boolean stop;

    /**
     * Constructor.
     *
     * @param value - some int value.
     * @param stop  - boolean value.
     */
    public Demonstration(int value, boolean stop) {
        this.value = value;
        this.stop = stop;
    }

    /**
     * Some thread's action showing some its work.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() || this.value < 50) {
            if (this.stop) {
                //    this.value += 2;
                this.value *= 2;
                this.stop = false;
                System.out.println(Thread.currentThread().getName() + " : " + value);
                Thread.currentThread().interrupt();
            } else {
                this.stop = true;
            }
        }
    }

    /**
     * Starts this example code above.
     *
     * @param args - strings
     */
    public static void main(String[] args) {
        Demonstration demo = new Demonstration(1, false);
        new Thread(demo).start();
        new Thread(demo).start();
    }
}
