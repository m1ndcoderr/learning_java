package ru.evgenyhodz.models;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PawnTest {
    @Test
    public void moveTest() {
        Pawn pawn = new Pawn("Pawn", "White", 6, 3);
        Board board = new Board();
        board.add(pawn);
        pawn.move(board, 6, 3, 5, 3);
        assertThat(board.check(5, 3), is(false));
        assertThat(board.check(6, 3), is(true));
    }

    @Test
    public void attackMoveTest() {
        Pawn pawn1 = new Pawn("Pawn", "White", 6, 3);
        Pawn pawn2 = new Pawn("Pawn", "Black", 5, 3);
        Board board = new Board();
        board.add(pawn1);
        board.add(pawn2);
        pawn1.move(board, 6, 3, 5, 3);
        assertThat(board.showColor(5, 3), is("White"));
    }

    @Test
    public void errorTest() {
        Board board = new Board();
        Pawn pawn1 = new Pawn("Pawn", "White", 6, 3);
        Pawn pawn2 = new Pawn("Pawn", "White", 5, 3);
        board.add(pawn1);
        board.add(pawn2);
        pawn1.move(board, 6, 3, 5, 3);
        assertThat(board.showColor(6, 3), is("White"));
        assertThat(board.showColor(5, 3), is("White"));
    }
}