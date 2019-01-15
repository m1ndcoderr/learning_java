package ru.evgenyhodz.bomberman;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.03.2017
 */
class Bomberman extends Figure {
    /**
     * Constructor.
     *
     * @param x         - coordinate.
     * @param y         - coordinate.
     * @param type      - type of figure.
     * @param stepMaker - class for making steps.
     * @param field     - game field.
     */
    Bomberman(int x, int y, FigureType type, StepMaker stepMaker, GameField field) {
        super(x, y, type, stepMaker, field);
    }

    /**
     * Moves figure on the game field.
     *
     * @param step - direction.
     */
    @Override
    void move(Step step) {
        if (step != null) {
            Figure[][] f = this.gameField.getGameField();
            int[] destination = getStepMaker().getDestination(getX(), getY(), step);
            if (checkMove(destination, f)) {
                f[destination[0]][destination[1]] = new Bomberman(
                        destination[0], destination[1],
                        FigureType.BOMBERMAN, gameField.getStepMaker(), gameField);
                f[getX()][getY()] = null;
            } else {
                System.out.println("Impossible move.");
            }
        } else {
            System.out.println("Step can't be null.");
        }
    }
}

