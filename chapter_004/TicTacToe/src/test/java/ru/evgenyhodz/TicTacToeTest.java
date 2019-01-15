package ru.evgenyhodz;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 18.01.2017
 */
public class TicTacToeTest {
    /**
     * Size of the game field for tests.
     */
    private static final int SIZE = 3;

    /**
     * Simple test of getting int variable.
     */
    @Test
    public void whenGetFirstMoveNumberBeforeGameThenGetNullTest() {
        TicTacToe ticTacToe = new TicTacToe(new Input(), new TurnCheck());
        int expected = 0;
        assertThat(ticTacToe.getFirstMove(), is(expected));
    }

    /**
     * Simple test of getting int variable.
     */
    @Test
    public void whenGetWinCountBeforeGameThenGetNullTest() {
        TicTacToe ticTacToe = new TicTacToe(new Input(), new TurnCheck());
        int expected = 0;
        assertThat(ticTacToe.getCountOfWins(), is(expected));
    }

    /**
     * Simple test of getter.
     */
    @Test
    public void whenUseGetterThenGetGameFieldTest() {
        TicTacToe ticTacToe = new TicTacToe(new Input(), new TurnCheck());
        ticTacToe.createGameField(SIZE);
        String[][] g = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(ticTacToe.getField(), is(g));
    }

    /**
     * Test of creating field.
     */
    @Test
    public void whenCreateSimpleGameFieldThenGetGameField() {
        TicTacToe ticTacToe = new TicTacToe(new Input(), new TurnCheck());
        ticTacToe.createGameField(SIZE);
        String[][] g = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(ticTacToe.getField(), is(g));
    }

    /**
     * Test. We should have a winner.
     */
    @Test
    public void whenWeHaveMatchesThenThereIsAWinnerTest() {
        TurnCheck turnCheck = new TurnCheck();
        TicTacToe ticTacToe = new TicTacToe(new Input(), turnCheck);
        String[][] f = {
                {" X ", " O ", " O "},
                {" X ", " X ", "[ ]"},
                {" X ", " O ", "[ ]"}
        };
        assertThat(ticTacToe.declareWinner(f), is(true));
    }

    /**
     * We should have a draw. Result should be TRUE.
     */
    @Test
    public void whenThereIsNoEmptyCellsThenItIsDrawTest() {
        TurnCheck turnCheck = new TurnCheck();
        TicTacToe ticTacToe = new TicTacToe(new Input(), turnCheck);
        String[][] f = {
                {" X ", " X ", " O "},
                {" O ", " X ", " X "},
                {" X ", " O ", " O "}
        };
        assertThat(ticTacToe.declareWinner(f), is(true));
    }

    /**
     * Test of getting random number value between 1 and 2.
     */
    @Test
    public void whenRandomActThenGetOneOrAnotherNumberInGetFirstMoveTest() {
        TicTacToe ticTacToe = new TicTacToe(new Input(), new TurnCheck());
        ticTacToe.randomActFirst();
        assertThat((double) ticTacToe.getFirstMove(), closeTo(1d, 2d));
    }

}