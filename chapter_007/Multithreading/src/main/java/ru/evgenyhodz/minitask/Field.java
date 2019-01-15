package ru.evgenyhodz.minitask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.04.2017
 */
public class Field {

    private Cell[][] objects = new Cell[5][5];

    public Cell[][] getObjects() {
        return objects;
    }

    public void fill() {
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                this.objects[i][j] = new Cell(new ReentrantLock());
            }
        }
    }

    public void show(Cell[][] field) {
        class FormattedTablePrint {
            private void printRow(Cell[] row) {
                for (Cell i : row) {
                    if (i != null && i.getReentrantLock().isLocked()) {
                        System.out.print("[C]");
                    } else if (i != null && !i.getReentrantLock().isLocked()) {
                        System.out.print("[O]");
                    }
                    System.out.print("\t");
                }
                System.out.println();
            }
        }
        FormattedTablePrint ftp = new FormattedTablePrint();
        for (Cell[] row : field) {
            ftp.printRow(row);
        }
        System.out.println("-------------------\n");
    }
}
