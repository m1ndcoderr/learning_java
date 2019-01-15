package ru.evgenyhodz.minitask;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.04.2017
 */
public class RLocker extends Thread {

    private Field field;
    private static final int MILLIS = 100;

    public RLocker(Field field) {
        this.field = field;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 1000) {
            lockCell(field.getObjects());
            i++;
        }
    }

    private void lockCell(Cell[][] field) {
        String name = Thread.currentThread().getName();
        int x = ThreadLocalRandom.current().nextInt(field.length);
        int y = ThreadLocalRandom.current().nextInt(field.length);
        Cell cell = field[x][y];
        if (!cell.getReentrantLock().isLocked()) {
            try {
                cell.getReentrantLock().lock();
                System.out.println(name + ": Cell[" + x + "][" + y + "] locked for a " + MILLIS + " millis");
                Thread.currentThread().sleep(MILLIS);
                cell.getReentrantLock().unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(name + ": Position [" + x + "][" + y + "] is locked now. Going to another...");
        }
    }
}
