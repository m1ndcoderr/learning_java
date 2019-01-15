package ru.evgenyhodz.models;

/**
 * Abstract class describing a chess piece.
 *
 * @author Evgeny Khodzitskiy.
 */
abstract class Figure {
    /**
     * Message object.
     */
    Message message = new Message();
    /**
     * Type of piece.
     */
    private String type;
    /**
     * Color of piece.
     */
    private String color;
    /**
     * X-axis of board.
     */
    int x;
    /**
     * Y-axis of board.
     */
    int y;

    /**
     * Constructor of piece.
     *
     * @param type  - type of piece.
     * @param color - color of piece.
     * @param x     - x-axis of chessboard.
     * @param y     - y-axis of chessboard.
     */
    Figure(String type, String color, int x, int y) {
        this.color = color;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * Getter.
     *
     * @return - string value - color of piece.
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter.
     *
     * @return - string value - type of piece.
     */
    public String getType() {
        return type;
    }

    /**
     * Getter.
     *
     * @return int value - x-axis position on chessboard.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter.
     *
     * @return int value - y-axis position on chessboard.
     */
    public int getY() {
        return y;
    }

    /**
     * Abstract method to move chess piece.
     *
     * @param board  - chessboard.
     * @param startX - start position - x-axis of board.
     * @param startY - start position - y-axis of board.
     * @param destX  - destination - x-axis of board.
     * @param destY  - destination - y-axis of board.
     */
    public abstract void move(Board board, int startX, int startY, int destX, int destY);
}
