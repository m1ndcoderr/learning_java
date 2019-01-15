package ru.evgenyhodz;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 09.01.2017
 */
class TicTacToe {
    /**
     * Number to know who is making the first move in the game.
     */
    private int firstMove = 0;
    /**
     * Number of cells with 'X'.
     */
    private int countX = 0;
    /**
     * Number of cells with 'O'.
     */
    private int countO = 0;
    /**
     * Number of wins.
     */
    private int countOfWins = 0;
    /**
     * Number of loses.
     */
    private int countOfLoses = 0;
    /**
     * Object to read from keyboard.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ref to user's input.
     */
    private Input inp;
    /**
     * Ref to validate class.
     */
    private TurnCheck turnCheck;
    /**
     * Ref to game field.
     */
    private String[][] field;
    /**
     * Message for user if his input was incorrect.
     */
    private static final List<String> TEXT = Lists.newArrayList(
            "Ooops! There was a little error:",
            "No such coordinate OR this cell was already filled with value.",
            "Remember, that possible values for X and Y in standard game are 1-3,",
            "(If it's not standard, it equal to 1-length of field you created),",
            "AND you can't do your move on NOT empty cell in the game.",
            "Please, re-enter correct coordinates.");

    /**
     * Getter.
     *
     * @return int value.
     */
    int getFirstMove() {
        return firstMove;
    }

    /**
     * Getter.
     *
     * @return - ' X ' count.
     */
    private int getCountX() {
        return countX;
    }

    /**
     * Getter.
     *
     * @return - ' O ' count.
     */
    private int getCountO() {
        return countO;
    }

    /**
     * Getter.
     *
     * @return - number of wins.
     */
    int getCountOfWins() {
        return countOfWins;
    }

    /**
     * Getter.
     *
     * @return - number of loses.
     */
    private int getCountOfLoses() {
        return countOfLoses;
    }

    /**
     * Constructor.
     *
     * @param input    - user's input.
     * @param validate - validation class.
     */
    TicTacToe(Input input, TurnCheck validate) {
        this.inp = input;
        this.turnCheck = validate;
    }

    /**
     * Getter.
     *
     * @return field.
     */
    String[][] getField() {
        return field;
    }

    /**
     * Method to create two dimensional array-field of game.
     *
     * @param side - size of side of the field.
     */
    void createGameField(int side) {
        field = new String[side][side];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = "[ ]";
            }
        }
    }

    /**
     * Method for doing human turn.
     *
     * @param board - game field.
     */
    private void humanMove(String[][] board) {
        System.out.println("Enter X (row num) and Y(column num):");
        int x = inp.input(scanner);
        int y = inp.input(scanner);
        if (x <= board.length - 1 && y <= board.length - 1 && x > -1 && y > -1
                && board[x][y].equals("[ ]")) {
            board[x][y] = " X ";
        } else {
            System.out.println(Joiner.on("\n").join(TEXT));
            humanMove(board);
        }
    }

    /**
     * This is how computer makes turn.
     */
    private void compMove() {
        int x = (int) (Math.random() * field.length);
        int y = (int) (Math.random() * field.length);
        while (!field[x][y].equals("[ ]")) {
            x = (int) (Math.random() * field.length);
            y = (int) (Math.random() * field.length);
        }
        field[x][y] = " O ";
    }

    /**
     * Second computer player.
     */
    private void anotherCompMove() {
        int x = (int) (Math.random() * field.length);
        int y = (int) (Math.random() * field.length);
        while (!field[x][y].equals("[ ]")) {
            x = (int) (Math.random() * field.length);
            y = (int) (Math.random() * field.length);
        }
        field[x][y] = " X ";
    }


    /**
     * Method to print our field to console.
     *
     * @param board - game field.
     */
    private void printField(String[][] board) {
        /**
         * Inner class realizing printing of our game field to console.
         */
        class FormattedTablePrint {
            /**
             * Method to print every row of 2-dimensional array.
             * @param row - 2D row.l
             */
            private void printRow(String[] row) {
                for (String i : row) {
                    System.out.print(i);
                    System.out.print("\t");
                }
                System.out.println();
            }
        }
        FormattedTablePrint ftp = new FormattedTablePrint();
        for (String[] row : board) {
            ftp.printRow(row);
        }
        System.out.println("------------");
    }

    /**
     * Method to check cell matches. If value of cell equals "X",
     * X_COUNT value +1. Else of value of cell equals "O",
     * O_COUNT value +1.
     *
     * @param board - game field.
     */
    private void check(String[][] board) {
        countX = 0;
        countO = 0;
        List<String> list = new ArrayList<>();
        for (String[] aField : board) {
            Collections.addAll(list, aField);
        }
        for (String aList : list) {
            if (aList.equals(" X ")) {
                countX++;
            } else if (aList.equals(" O ")) {
                countO++;
            }
        }
    }

    /**
     * Method to compare number of "X" and "O" on the game field,
     * and to count the number of wins and loses of the players.
     *
     * @param board - game field.
     */
    private void count(String[][] board) {
        check(board);
        if (getCountX() > getCountO() && turnCheck.canMove(board)) {
            countOfWins++;
        }
        if (getCountX() < getCountO() && turnCheck.canMove(board)) {
            countOfLoses++;
            countOfWins = 0;
        }
        if (getCountX() < getCountO() && !turnCheck.canMove(board)) {
            countOfLoses++;
            countOfWins = 0;
        }
    }

    /**
     * Method to declare the results of the game.
     *
     * @param board - game field.
     * @return boolean value - true/false. If we have any matches on the field - returns true.
     */
    boolean declareWinner(String[][] board) {
        boolean end = false;
        if (turnCheck.validate(board)) {
            count(board);
            if (getCountOfWins() == 1) {
                System.out.println("YOU ARE WINNER!");
                end = true;
            } else if (getCountOfLoses() == 1) {
                System.out.println("YOU ARE LOSER!");
                end = true;
            } else if (!turnCheck.canMove(board)) {
                end = true;
                countOfWins = 0;
                System.out.println("DRAW!");
            }
        }
        return end;
    }

    /**
     * Process of the game. Human do the first move.
     */
    void actHumanFirst() {
        if (!declareWinner(field)) {
            humanMove(field);
        } else {
            printField(getField());
            declareWinner(field);
        }
        if (!declareWinner(field)) {
            compMove();
            printField(field);
        } else {
            printField(getField());
            declareWinner(field);
        }
    }

    /**
     * Computer do the first move.
     */
    void actComputerFirst() {
        if (!declareWinner(getField())) {
            compMove();
            printField(getField());
        } else {
            printField(getField());
            declareWinner(getField());
        }
        if (!declareWinner(getField())) {
            humanMove(getField());
        } else {
            declareWinner(getField());
        }
    }

    /**
     * To see the game between two computers.
     */
    void betweenComputers() {
        if (!declareWinner(field)) {
            anotherCompMove();
            printField(field);
        } else {
            declareWinner(field);
        }
        if (!declareWinner(field)) {
            compMove();
        } else {
            declareWinner(field);
        }
    }

    /**
     * Method choose who will start the game randomly.
     */
    void randomActFirst() {
        Random rand = new Random();
        int num = 1 + rand.nextInt(2);
        if (num == 1) {
            System.out.println("Do the first move.");
            firstMove = 1;
        } else if (num == 2) {
            System.out.println("Computer did the first move.");
            firstMove = 2;
        }
    }
}
