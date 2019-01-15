package ru.evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 10.01.2017
 */
public class TurnCheckTest {
    /**
     * Checking if we don't have an empty cell.
     */
    @Test
    public void cantMove() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {" O ", " O ", " O "},
                {" O ", " O ", " O "},
                {" O ", " O ", " O "}
        };
        assertThat(turnCheck.canMove(f), is(false));
    }

    /**
     * Checking if we have an empty cell.
     */
    @Test
    public void whenWeHaveEmptyCellThenWeStillCanMoveTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {" O ", " O ", " O "},
                {" O ", " O ", " O "},
                {" O ", " O ", "[ ]"}
        };
        assertThat(turnCheck.canMove(f), is(true));
    }

    /**
     * Checking diagonal '\'. Test of validate().
     */
    @Test
    public void whenWeCheckDiagonalThenWeGotTrueTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {" O ", "[ ]", "[ ]"},
                {"[ ]", " O ", "[ ]"},
                {"[ ]", "[ ]", " O "}
        };
        assertThat(turnCheck.validate(f), is(true));
    }

    /**
     * Checking if we have an empty cell. Test of validate().
     */
    @Test
    public void whenWeCheckEmptyCellsThenWeGotResultTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {" X ", " O ", " X "},
                {" X ", " X ", " O "},
                {" O ", " O ", "[ ]"}
        };
        assertThat(turnCheck.validate(f), is(false));
    }

    /**
     * Checking diagonal '\'.
     */
    @Test
    public void whenWeCheckDiagonalThenWeGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {" O ", "[ ]", "[ ]"},
                {"[ ]", " O ", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkDiagonal(f), is(false));
    }

    /**
     * Checking diagonal '\'.
     */
    @Test
    public void whenWeCheckDiagonalThenWeGetTrueTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {" O ", "[ ]", "[ ]"},
                {"[ ]", " O ", "[ ]"},
                {"[ ]", "[ ]", " O "}
        };
        assertThat(turnCheck.checkDiagonal(f), is(true));
    }

    /**
     * Checking diagonal '/'.
     */
    @Test
    public void whenCheckDiagonalThenGetTrueTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {"[ ]", "[ ]", " O "},
                {"[ ]", " O ", "[ ]"},
                {" O ", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkAnotherDiagonal(f), is(true));
    }

    /**
     * Checking diagonal '/'.
     */
    @Test
    public void whenCheckDiagonalThenGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", " O ", "[ ]"},
                {" O ", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkAnotherDiagonal(f), is(false));
    }

    /**
     * Checking rows.
     */
    @Test
    public void checkHorizontal() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] g = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {" X ", " X ", " X "}
        };
        assertThat(turnCheck.checkHorizontal(g), is(true));
    }

    /**
     * Checking columns.
     */
    @Test
    public void checkVertical() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] v = {
                {" O ", "[ ]", "[ ]"},
                {" O ", "[ ]", "[ ]"},
                {" O ", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkVertical(v), is(true));
    }

    /**
     * Checking if we have an empty field. Test of validate().
     * SHOULD BE FALSE, there is no matches.
     * checkHorizontal
     */
    @Test
    public void whenWeCheckEmptyFieldThenWeGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkHorizontal(f), is(false));

    }

    /**
     * Checking rows.
     * SHOULD BE FALSE, there is no matches.
     * checkHorizontal
     */
    @Test
    public void whenWeDontHaveRowMatchesThenGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] g = {
                {"[ ]", " X ", "[ ]"},
                {"[ ]", " X ", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkHorizontal(g), is(false));
    }

    /**
     * Checking columns.
     */
    @Test
    public void whenWeDoNotHaveColumnMatchThenGetFalse() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] v = {
                {" O ", "[ ]", "[ ]"},
                {" O ", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkVertical(v), is(false));
    }

    /**
     * Checking columns.
     */
    @Test
    public void whenCheckEmptyFieldThenGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] v = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkVertical(v), is(false));
    }

    /**
     * Checking diagonal '/'.
     * Validation of checkAnotherDiagonal
     */
    @Test
    public void whenCheckDiagonalEmptyFieldThenGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkAnotherDiagonal(f), is(false));
    }

    /**
     * Checking diagonal '\'.
     * Test of checkDiagonal
     */
    @Test
    public void whenCheckDiagonalEmptyBoardThenGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkDiagonal(f), is(false));
    }

    /**
     * Checking diagonal '\'.
     * Test of checkDiagonal
     */
    @Test
    public void whenCheckDiagonalOneCornerBoardThenGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {" X ", "[ ]", "[ ]"},
                {"[ ]", " X ", "[ ]"},
                {"[ ]", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkDiagonal(f), is(false));
    }

    /**
     * Checking diagonal '/'.
     * Test of checkAnotherDiagonal
     */
    @Test
    public void whenCheckAnotherDiagonalOneCornerBoardThenGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {"[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {" O ", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.checkAnotherDiagonal(f), is(false));
    }

    /**
     * Checking validate(String[][] field).
     */
    @Test
    public void whenCheckFieldThenGetFalseTest() {
        TurnCheck turnCheck = new TurnCheck();
        String[][] f = {
                {" X ", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]"},
                {" O ", "[ ]", "[ ]"}
        };
        assertThat(turnCheck.validate(f), is(false));
    }
}