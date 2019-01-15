package ru.evgenyhodz.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void addTest() {
        Pawn pawn = new Pawn("Pawn", "White", 6, 3);
        Board board = new Board();
        board.add(pawn);
        assertThat(board.check(6, 3), is(false));
    }

    @Test
    public void deleteTest() {
        Pawn pawn = new Pawn("Pawn", "White", 6, 3);
        Board board = new Board();
        board.add(pawn);
        board.delete(6, 3);
        assertThat(board.check(6, 3), is(true));
    }

    @Test
    public void checkTest() {
        Pawn pawn = new Pawn("Pawn", "White", 6, 3);
        Board board = new Board();
        board.add(pawn);
        assertThat(board.check(6, 3), is(false));
    }

    @Test
    public void takePawnTest() {
        Pawn pawn = new Pawn("Pawn", "White", 6, 3);
        Board board = new Board();
        board.add(pawn);
        assertThat(board.takePawn(6, 3).getColor(), is("White"));
    }

    @Test
    public void takeKingTest() {
        King king = new King("Pawn", "White", 5, 3);
        Board board = new Board();
        board.add(king);
        assertThat(board.takePawn(5, 3).getColor(), is("White"));
    }

    @Test
    public void takeKnightTest() {
        Knight knight = new Knight("Pawn", "White", 4, 3);
        Board board = new Board();
        board.add(knight);
        assertThat(board.takePawn(4, 3).getColor(), is("White"));
    }

    @Test
    public void fillTest() {
        Board board = new Board();
        board.fill();
        assertThat(board.takeKnight(7, 1).getType(), is("Knight"));
        assertThat(board.takeKing(0, 4).getType(), is("King"));
        assertThat(board.showColor(1, 0), is("Black"));
    }
}