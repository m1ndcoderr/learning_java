package ru.evgenyhodz.models;

/**
 * Class describing Knight and its movement.
 */
public class Knight extends Figure {
    /**
     * Constructor of piece.
     *
     * @param type  - type of piece.
     * @param color - color of piece.
     * @param x     - x-axis of chessboard.
     * @param y     - y-axis of chessboard.
     */
    public Knight(String type, String color, int x, int y) {
        super(type, color, x, y);
    }

    /**
     * That's how Knight do its move.
     *
     * @param board  - chessboard.
     * @param startX - start position - x-axis of board.
     * @param startY - start position - y-axis of board.
     * @param destX  - destination - x-axis of board.
     * @param destY  - destination - y-axis of board.
     */
    @Override
    public void move(Board board, int startX, int startY, int destX, int destY) {
        if (board.moveLikeKnightOrNot(startX, destX, startY, destY)) {
            if (board.check(destX, destY)) {
                board.add(new Knight(board.takeKnight(startX, startY).getType(),
                        board.takeKnight(startX, startY).getColor(), destX, destY));
                board.delete(startX, startY);
            } else if (!board.check(destX, destY) && board.showColor(startX, startY).equals(board.showColor(destX, destY))) {
                message.ourSoldiers();
            } else if (!board.check(destX, destY) && !board.showColor(startX, startY).equals(board.showColor(destX, destY))) {
                board.delete(destX, destY);
                board.add(new Knight(board.takeKnight(startX, startY).getType(),
                        board.takeKnight(startX, startY).getColor(), destX, destY));
                board.delete(startX, startY);
            }
        }
    }
}
