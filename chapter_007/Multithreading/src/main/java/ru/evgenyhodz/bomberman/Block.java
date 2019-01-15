package ru.evgenyhodz.bomberman;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.03.2017
 */
public class Block extends Figure {
    /**
     * Constructor.
     *
     * @param x         - coordinate.
     * @param y         - coordinate.
     * @param type      - type of figure.
     * @param stepMaker - class for making steps.
     * @param field     - game field.
     */
    Block(int x, int y, FigureType type, StepMaker stepMaker, GameField field) {
        super(x, y, type, stepMaker, field);
    }

    @Override
    public void move(Step step) {
        System.out.println("I'm a block and I can't do steps.");
    }
}
