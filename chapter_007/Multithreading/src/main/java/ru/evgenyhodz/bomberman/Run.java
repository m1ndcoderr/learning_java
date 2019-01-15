package ru.evgenyhodz.bomberman;

import java.util.concurrent.BrokenBarrierException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 30.03.2017
 */
public class Run {
    private static GameField gameField;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        gameField = new GameField();
        gameField.init(15, 7, 7);
      //  new Printer().start();
        gameField.startMonsters();
        gameField.getGate().await();
    }

    private static class Printer extends Thread {
        @Override
        public void run() {
            printField(gameField.getGameField());
        }

        /**
         * Метод для визуализации происходящего внутри.
         * Method to print our field to console.
         *
         * @param board - game field.
         */
        public void printField(Figure[][] board) {
            /**
             * Inner class realizing printing of our game field to console.
             */
            class FormattedTablePrint {
                /**
                 * Method to print every row of 2-dimensional array.
                 * @param row - 2D row.l
                 */
                private void printRow(Figure[] row) {
                    for (Figure i : row) {
                        if (i != null && i.getType() == FigureType.BOMBERMAN) {
                            System.out.print("[B]");
                        } else if (i != null && i.getType() == FigureType.MONSTER) {
                            System.out.print("[M]");
                        } else if (i != null && i.getType() == FigureType.BLOCK) {
                            System.out.print("[+]");
                        } else {
                            System.out.print("[ ]");
                        }
                        System.out.print("\t");
                    }
                    System.out.println();
                }
            }
            FormattedTablePrint ftp = new FormattedTablePrint();
            for (Figure[] row : board) {
                ftp.printRow(row);
            }
            System.out.println("-----------------\n");
            try {
                Thread.currentThread().sleep(1000);
                printField(board);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
