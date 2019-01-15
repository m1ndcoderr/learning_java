package ru.evgenyhodz.models;

/**
 * Class describing Pawn.
 */
public class Pawn extends Figure {
    /**
     * Constructor of piece.
     *
     * @param type  - type of piece.
     * @param color - color of piece.
     * @param x     - x-axis of chessboard.
     * @param y     - y-axis of chessboard.
     */
    Pawn(String type, String color, int x, int y) {
        super(type, color, x, y);
    }

    /**
     * This is how pawn can move on the chessboard.
     *
     * @param board  - chessboard.
     * @param startX - start position - x-axis of board.
     * @param startY - start position - y-axis of board.
     * @param destX  - destination - x-axis of board.
     * @param destY  - destination - y-axis of board.
     */
    @Override
    public void move(Board board, int startX, int startY, int destX, int destY) {
        if (!board.check(startX, startY) && (Math.abs(destX - startX) != 1 || Math.abs(destY - startY) != 0)) {
            message.impossibleMove();
        } else if (board.check(startX, startY)) {
            message.error();
        } else if (!board.check(destX, destY) && board.showColor(startX, startY).equals(board.showColor(destX, destY))) {
            message.ourSoldiers();
        } else {
            board.delete(destX, destY);
            board.add(new Pawn(board.takePawn(startX, startY).getType(),
                    board.takePawn(startX, startY).getColor(),
                    destX, destY));
            board.delete(startX, startY);
        }
    }
}
