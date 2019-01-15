package ru.evgenyhodz.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class KingTest {
    @Test
    public void moveTest() {
        Board board = new Board();
        King king = new King("King", "White", 0, 0);
        board.add(king);
        king.move(board, 0, 0, 1, 1);
        assertThat(board.check(1, 1), is(false));
    }

    @Test
    public void attackMoveTest() {
        Board board = new Board();
        King king = new King("King", "White", 0, 0);
        Pawn pawn = new Pawn("Pawn", "Black", 1, 1);
        board.add(king);
        board.add(pawn);
        king.move(board, 0, 0, 1, 1);
        assertThat(board.check(1, 1), is(false));
        assertThat(board.showColor(1, 1), is("White"));
    }

    @Test
    public void errorTest() {
        Board board = new Board();
        King king = new King("King", "White", 0, 0);
        Pawn pawn = new Pawn("Pawn", "White", 1, 1);
        board.add(king);
        board.add(pawn);
        king.move(board, 0, 0, 1, 1);
        king.move(board, 0, 0, 2, 2);
        assertThat(board.showColor(0, 0), is("White"));
    }
}