package ru.evgenyhodz.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class KnightTest {
    @Test
    public void moveTest() {
        Board board = new Board();
        Knight knight = new Knight("Knight", "White", 4, 3);
        board.add(knight);
        knight.move(board, 4, 3, 6, 4);
        assertThat(board.check(6, 4), is(false));
    }

    @Test
    public void attackTest() {
        Board board = new Board();
        Knight knight = new Knight("Knight", "White", 4, 3);
        Pawn pawn = new Pawn("Pawn", "Black", 6, 4);
        board.add(knight);
        board.add(pawn);
        knight.move(board, 4, 3, 6, 4);
        assertThat(board.check(6, 4), is(false));
        assertThat(board.showColor(6, 4), is("White"));
    }

    @Test
    public void errorTest() {
        Board board = new Board();
        Knight knight = new Knight("Knight", "White", 0, 0);
        Pawn pawn = new Pawn("Pawn", "White", 2, 1);
        board.add(knight);
        board.add(pawn);
        knight.move(board, 0, 0, 2, 1);
        knight.move(board, 0, 0, 2, 2);
        assertThat(board.showColor(0, 0), is("White"));
    }

}