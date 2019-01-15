package ru.evgenyhodz.bomberman;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.03.2017
 */
public class Monster extends Figure implements Runnable {
    /**
     * Time to wait after wrong direction.
     */
    private final static int fiveSeconds = 5000;
    /**
     * Выбранное ранее направление движения.
     */
    private Step chosenBefore;

    /**
     * Constructor.
     *
     * @param x         - coordinate.
     * @param y         - coordinate.
     * @param type      - type of figure.
     * @param stepMaker - class for making steps.
     * @param field     - game field.
     */
    Monster(int x, int y, FigureType type, StepMaker stepMaker, GameField field) {
        super(x, y, type, stepMaker, field);
    }

    /**
     * Получаем координаты, которые рассчитываются, исходя из текущих координат + случайное направление.
     * Проверяем, можем ли мы сделать ход. Если нет, текущая фигура останется на поле, а поток фигуры
     * отправится в очередь, чтобы быть вызванным снова. Если можем, создается новый монстр на поле и
     * отправляется в очередь как поток, который затем вызовут. Старый объект Monster нулится.
     *
     * @param step - direction.
     */
    @Override
    void move(Step step) {
        Figure[][] f = this.gameField.getGameField();
        long id = Thread.currentThread().getId();
        if (f[getX()][getY()] != null) {
            int[] destination = getStepMaker().getDestination(getX(), getY(), step);
            int a = destination[0];
            int b = destination[1];
            if (!checkMove(destination, f)) {
//                try {
                System.out.println("M-" + id + " can't move to ["
                        + a + ", " + b + "]. Looking for another way...\n");
//                    Thread.sleep(fiveSeconds);
                gameField.getMonsters().addFirst(new Thread(this));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            } else {
                Monster monster = new Monster(a, b, FigureType.MONSTER, getStepMaker(), gameField);
                f[a][b] = monster;
                gameField.getMonsters().addFirst(new Thread(monster));
                f[getX()][getY()] = null;
                System.out.println("M-" + id + " has moved to [" + a + ", " + b + "].\n");
            }
        }
    }

    /**
     * У нас есть переменная Step chosenBefore, при создании объекта равная null.
     * Мы пытаемся сделать ход, если он неудачен, то переменная изменит свое значение
     * и в следующий раз мы выберем другое направление. Если ход можно сделать, то
     * мы опять получаем null переменную, потому что создается другой объект Monster.
     */
    @Override
    public void run() {
//        ReentrantLock lock = this.gameField.getLock();
//        if (lock.tryLock()) {
//            lock.lock();
        synchronized (this.gameField) {
            if (this.chosenBefore == null) {
                this.chosenBefore = getStepMaker().choose();
            } else {
                Step way = this.chosenBefore;
                while (way == this.chosenBefore) {
                    this.chosenBefore = getStepMaker().choose();
                }
            }
            move(this.chosenBefore);
//            lock.unlock();
        }
    }
}
