package ru.evgenyhodz.models;

/**
 * Class describes chessboard.
 *
 * @author Evgeny Khodzitskiy.
 */
public class Board {
    /**
     * Array with figures.
     */
    private final Figure[][] board = new Figure[8][8];
    /**
     * Message class object.
     */
    private Message message = new Message();
    /**
     * Link to pawn.
     */
    private Pawn pawnResult;
    /**
     * Link to king.
     */
    private King kingResult;
    /**
     * Link to knight.
     */
    private Knight knightResult;

    /**
     * Method to add figure on the chessboard.
     *
     * @param figure - our figure.
     */
    public void add(Figure figure) {
        try {
            this.board[figure.getX()][figure.getY()] = figure;
        } catch (ArrayIndexOutOfBoundsException e) {
            message.noSuchPosition();
        }
    }

    /**
     * Deleting figure from desk.
     *
     * @param x - x-axis figure stands on.
     * @param y - y-axis figure stands on.
     */
    public void delete(int x, int y) {
        this.board[x][y] = null;
    }

    /**
     * Check if cell on chessboard empty.
     *
     * @param x - x-axis figure stands on.
     * @param y - y-axis figure stands on.
     * @return - true/false.
     */
    public boolean check(int x, int y) {
        boolean isEmpty;
        isEmpty = this.board[x][y] == null;
        return isEmpty;
    }

    /**
     * Put the pieces on the board.
     */
    public void fill() {
        this.add(new King("King", "White", 7, 4));
        this.add(new Knight("Knight", "White", 7, 1));
        this.add(new Knight("Knight", "White", 7, 6));
        for (int pW = 0; pW < board[1].length; pW++) {
            this.add(new Pawn("Pawn", "White", 6, pW));
        }
        this.add(new King("King", "Black", 0, 4));
        this.add(new Knight("Knight", "Black", 0, 1));
        this.add(new Knight("Knight", "Black", 0, 6));
        for (int pB = 0; pB < board[1].length; pB++) {
            this.add(new Pawn("Pawn", "Black", 1, pB));
        }
    }

    /**
     * Validation of knight move.
     *
     * @param x1 - start position - x-axis of board.
     * @param x2 - start position - y-axis of board.
     * @param y1 - destination - x-axis of board.
     * @param y2 - destination - y-axis of board.
     * @return - true/false.
     */
    public boolean moveLikeKnightOrNot(int x1, int x2, int y1, int y2) {
        boolean ableTo;
        if (Math.abs(x2 - x1) == 1 && Math.abs(y2 - y1) == 2) {
            ableTo = true;
        } else if (Math.abs(x2 - x1) == 2 && Math.abs(y2 - y1) == 1) {
            ableTo = true;
        } else {
            ableTo = false;
            message.impossibleMove();
        }
        return ableTo;
    }

    /**
     * Choosing pawn to make a move.
     *
     * @param x - x-axis figure stands on.
     * @param y - y-axis figure stands on.
     * @return - Pawn object.
     */
    public Pawn takePawn(int x, int y) {
        for (Figure[] aBoard : board) {
            for (int j = 0; j < board.length; j++) {
                if (aBoard[j] != null && aBoard[j].getX() == x && aBoard[j].getY() == y) {
                    this.pawnResult = new Pawn(aBoard[j].getType(),
                            aBoard[j].getColor(),
                            aBoard[j].getX(),
                            aBoard[j].getY());
                    break;
                }
            }
        }
        return pawnResult;
    }

    /**
     * Show color of the figure.
     *
     * @param x - x-axis figure stands on.
     * @param y - y-axis figure stands on.
     * @return - String value - color.
     */
    public String showColor(int x, int y) {
        return this.board[x][y].getColor();
    }

    /**
     * Choose king to make move.
     *
     * @param x - x-axis figure stands on.
     * @param y - y-axis figure stands on.
     * @return - King object.
     */
    public King takeKing(int x, int y) {
        for (Figure[] aBoard : board) {
            for (int j = 0; j < board.length; j++) {
                if (aBoard[j] != null && aBoard[j].getX() == x && aBoard[j].getY() == y) {
                    this.kingResult = new King(aBoard[j].getType(),
                            aBoard[j].getColor(),
                            aBoard[j].getX(),
                            aBoard[j].getY());
                    break;
                }
            }
        }
        return kingResult;
    }

    /**
     * Choose knight to make move.
     *
     * @param x - x-axis figure stands on.
     * @param y - y-axis figure stands on.
     * @return - Knight object.
     */
    public Knight takeKnight(int x, int y) {
        for (Figure[] aBoard : board) {
            for (int j = 0; j < board.length; j++) {
                if (aBoard[j] != null && aBoard[j].getX() == x && aBoard[j].getY() == y) {
                    this.knightResult = new Knight(aBoard[j].getType(),
                            aBoard[j].getColor(),
                            aBoard[j].getX(),
                            aBoard[j].getY());
                    break;
                }
            }
        }
        return knightResult;
    }
}
