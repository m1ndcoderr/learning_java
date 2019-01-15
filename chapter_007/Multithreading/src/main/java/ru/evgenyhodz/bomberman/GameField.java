package ru.evgenyhodz.bomberman;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.03.2017
 */
public class GameField {
    /**
     * Reference to 2D array contains figures.
     */
    private Figure[][] gameField;
    /**
     * Reference to list with monsters.
     */
    private ConcurrentLinkedDeque<Thread> monsters;
    /**
     * Reference class making steps.
     */
    private StepMaker stepMaker;

    private int monsterCount = 0;

    private ReentrantLock lock = new ReentrantLock();

    public ReentrantLock getLock() {
        return lock;
    }

    private CyclicBarrier gate = null;

    public CyclicBarrier getGate() {
        return gate;
    }

    /**
     * Returns StepMaker.
     *
     * @return - StepMaker.
     */
    public StepMaker getStepMaker() {
        return stepMaker;
    }

    /**
     * Returns array with threads.
     *
     * @return array.
     */
    public ConcurrentLinkedDeque<Thread> getMonsters() {
        return monsters;
    }

    /**
     * Getter.
     *
     * @return 2D array - game field.
     */
    public synchronized Figure[][] getGameField() {
        return gameField;
    }

    /**
     * Creates a game field and figures.
     *
     * @param size - size of our game field.
     */
    void init(int size, int x, int y) {
        this.gameField = new Figure[size][size];
        this.stepMaker = new StepMaker();
        this.stepMaker.fillEnumMap();
        this.monsters = new ConcurrentLinkedDeque<>();
        setBomberMan(x, y);
        setBlocks();
        setMonsters();
    }

    /**
     * Creates bomberman somewhere on the game field.
     */
    private void setBomberMan(int startX, int startY) {
        int l = gameField.length;
        if (startX >= 0 && startX < l && startY >= 0 && startY < l) {
            this.getGameField()[startX][startY] =
                    new Bomberman(startX, startY, FigureType.BOMBERMAN, stepMaker, this);
        } else {
            int cellX = new Random().nextInt(gameField.length);
            int cellY = new Random().nextInt(gameField.length);
            Bomberman hero = new Bomberman(cellX, cellY, FigureType.BOMBERMAN, stepMaker, this);
            this.gameField[cellX][cellY] = hero;
        }
    }

    /**
     * Расставляем блоки на поле.
     */
    private void setBlocks() {
        Random random = new Random();
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == null) {
                    int var = random.nextInt(6);
                    if (var != 0 && var == 1) {
                        this.gameField[i][j] = new Block(i, j, FigureType.BLOCK, stepMaker, this);
                    }
                }
            }
        }
    }

    /**
     * Создаем монстров на игровом поле.
     */
    private void setMonsters() {
        Random random = new Random();
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (this.gameField[i][j] == null) {
                    int var = random.nextInt(gameField.length / 2);
                    if (var != 0 && var == 1) {
                        Monster monster = new Monster(i, j, FigureType.MONSTER, stepMaker, this);
                        this.gameField[i][j] = monster;
                        this.monsters.add(new Thread(monster));
                        this.monsterCount++;
                    }
                }
            }
        }
    }

    /**
     * Waking up monsters.
     */
    void startMonsters() throws InterruptedException {
        this.gate = new CyclicBarrier(this.monsterCount + 1);
        for (int i = 0; i < monsterCount; i++) {
            new Taker().start();
        }
    }

    private class Taker extends Thread {
        @Override
        public void run() {
            try {
                gate.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            while (!monsters.isEmpty()) {
                monsters.pollLast().start();
                System.out.println("Taker-" + Thread.currentThread().getId() + " takes monster from queue.\n");
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
