package ru.evgenyhodz.start;

import ru.evgenyhodz.models.Board;
import ru.evgenyhodz.models.Knight;

/**
 * Class to start chess.
 */
public class Game {
    /**
     * Method to start program.
     *
     * @param args input params (empty).
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }

    /**
     * Init-method to start the program.
     */
    private void init() {
        Board board = new Board();
        Knight knight1 = new Knight("Knight", "White", 7, 1);
        Knight knight2 = new Knight("Knight", "White", 7, 5);
        board.add(knight1);
        board.add(knight2);
        knight1.move(board, 7, 1, 5, 2);
        knight2.move(board, 7, 5, 5, 6);
        System.out.println(knight1.getX());
        System.out.println(knight2.getY());
        board.fill();
        board.takeKnight(7, 1).move(board, 7, 1, 5, 0);
        System.out.print(board.check(5, 0));
    }
}
