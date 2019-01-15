package ru.evgenyhodz.models;

/**
 * Class describing a King and its move.
 */
public class King extends Figure {
    /**
     * Constructor of piece.
     *
     * @param type  - type of piece.
     * @param color - color of piece.
     * @param x     - x-axis of chessboard.
     * @param y     - y-axis of chessboard.
     */
    King(String type, String color, int x, int y) {
        super(type, color, x, y);
    }

    /**
     * That's how King move on chessboard.
     *
     * @param board  - chessboard.
     * @param startX - start position - x-axis of board.
     * @param startY - start position - y-axis of board.
     * @param destX  - destination - x-axis of board.
     * @param destY  - destination - y-axis of board.
     */
    @Override
    public void move(Board board, int startX, int startY, int destX, int destY) {
        if (destX >= -1 && destX <= 1 && destX >= -1 && destY <= 1) {
            if (board.check(destX, destY)) {
                board.add(new King(board.takeKing(startX, startY).getType(),
                        board.takeKing(startX, startY).getColor(), destX, destY));
                board.delete(startX, startY);
            } else if (!board.check(destX, destY) && board.showColor(startX, startY).equals(board.showColor(destX, destY))) {
                message.ourSoldiers();
            } else if (!board.check(destX, destY) && !board.showColor(startX, startY).equals(board.showColor(destX, destY))) {
                board.delete(destX, destY);
                board.add(new King(board.takeKing(startX, startY).getType(),
                        board.takeKing(startX, startY).getColor(), destX, destY));
                board.delete(startX, startY);
            }
        } else message.impossibleMove();
    }
}

