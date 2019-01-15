package ru.evgenyhodz.bomberman;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.03.2017
 */
abstract class Figure {
    /**
     * Coordinate x. Should be equals to coordinate on the game field.
     */
    private int x;
    /**
     * Coordinate y. Should be equals to coordinate on the game field.
     */
    private int y;
    /**
     * Name of the figure.
     */
    private FigureType type;
    /**
     * StepMaker reference.
     */
    private StepMaker stepMaker;
    /**
     * Reference to game field.
     */
    final GameField gameField;

    /**
     * Constructor.
     *
     * @param x         - coordinate.
     * @param y         - coordinate.
     * @param type      - type of figure.
     * @param stepMaker - class for making steps.
     * @param field     - game field.
     */
    Figure(int x, int y, FigureType type, StepMaker stepMaker, GameField field) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.stepMaker = stepMaker;
        this.gameField = field;
    }

    /**
     * Returns X coordinate.
     *
     * @return X.
     */
    int getX() {
        return x;
    }

    /**
     * Returns Y coordinate.
     *
     * @return Y.
     */
    int getY() {
        return y;
    }

    /**
     * Returns figure type.
     *
     * @return enum type.
     */
    FigureType getType() {
        return type;
    }

    /**
     * Getter.
     *
     * @return StepMaker.
     */
    StepMaker getStepMaker() {
        return stepMaker;
    }

    /**
     * Moves figure to destination.
     *
     * @param step - direction.
     */
    abstract void move(Step step);

    /**
     * Check our destination coordinates. We'll get true, if our coordinate:
     * 1) is not out of our game field,
     * 2) is empty to make a step.
     * We'll get false if coordinates are not empty or they are not correct.
     *
     * @param coordinates - some array with coordinates.
     * @param gameField   - game field.
     * @return boolean.
     */
    boolean checkMove(int[] coordinates, Figure[][] gameField) {
        boolean result = false;
        if (coordinates[0] >= 0 && coordinates[0] < gameField.length &&
                coordinates[1] >= 0 && coordinates[1] < gameField.length &&
                gameField[coordinates[0]][coordinates[1]] == null) {
            result = true;
        }
        return result;
    }
}
