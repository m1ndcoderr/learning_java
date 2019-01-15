package ru.evgenyhodz.bomberman;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 12.04.2017
 */
public class StepMakerTest {
    /**
     * StepMaker's object.
     */
    private final StepMaker stepMaker = new StepMaker();
    /**
     * Game field object.
     */
    private final Figure[][] field = new Figure[5][5];
    /**
     * Field to be filled with objects.
     */
    private final Figure[][] fullField = new Figure[5][5];
    /**
     * Array with values.
     */
    private final int[] correctValues = {3, 4};
    /**
     * Array with values.
     */
    private final int[] notCorrectValues = {-1, 2};
    /**
     * Another coordinates for test.
     */
    private final int[] someValues = {2, 2};

//    /**
//     * Creating field full of monsters.
//     */
//    @Before
//    public void fill() {
//        for (int i = 0; i < fullField.length; i++) {
//            for (int j = 0; j < fullField[i].length; j++) {
//                this.fullField[i][j] = new Monster(i, j, "Monster", fullField);
//            }
//        }
//    }

//    /**
//     * If destination cell is not empty, we should get false.
//     */
//    @Test
//    public void whenCheckCoordinateThenGetFalseBecauseItsNotEmpty() {
//        boolean result = stepMaker.checkMove(someValues, fullField);
//        assertThat(result, is(false));
//    }
//
//    /**
//     * Check non-correct values.
//     */
//    @Test
//    public void whenCheckNewCoordinatesToMoveThenGetFalse() {
//        boolean result = stepMaker.checkMove(notCorrectValues, field);
//        assertThat(result, is(false));
//    }
//
//    /**
//     * Check correct values.
//     */
//    @Test
//    public void whenCheckCorrectCoordinatesThenGetTrue() {
//        boolean result = stepMaker.checkMove(correctValues, field);
//        assertThat(result, is(true));
//    }

//    /**
//     * Trying to make step.
//     */
//    @Test
//    public void whenGetNewDestination() {
//        stepMaker.getDestination(0, 0, Step.DOWN);
//        int[] destination = stepMaker.getDestXAndY();
//        assertThat(destination[0], is(1));
//    }

    /**
     * If our hand-made step is impossible, we'll get a message and a random step.
     */
    @Test
    public void whenFigureCantMoveThenGetAMessageAndRandomMove() {
        final Figure[][] someField = new Figure[2][2];
        stepMaker.getDestination(0, 0, Step.LEFT);
        //TODO result is a message + random coordinates, how to check that?
    }
}