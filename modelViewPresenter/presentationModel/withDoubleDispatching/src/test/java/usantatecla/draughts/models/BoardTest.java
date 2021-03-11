package usantatecla.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;

public class BoardTest {

    @Test
    public void testGivenBoardWhenDraughtIsBlockedThenFalse() {
        Board board = new BoardBuilder().rows(
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "B       "
        ).build();
        assertThat(board.isBlocked(new Coordinate(7, 0)), is(false));
    }

    @Test
    public void testGivenBoardWhenDraughtJumpThenCorrect() {
        Board board = new BoardBuilder().rows(
            "        ",
            "        ",
            "        ",
            "    w   ",
            "        ",
            "        ",
            "        ",
            "B       "
        ).build();
        Coordinate origin = new Coordinate(7, 0);
        Coordinate target = new Coordinate(2, 5);
        board.movePiece(origin, target);
        assertThat(board.getPiece(origin), is(Piece.NULL));
        assertThat(board.getPiece(target), is(new Draught(Color.BLACK)));
        assertThat(board.getPiece(new Coordinate(3, 4)), is(Piece.NULL));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenTrue() {
        Board board = new BoardBuilder().rows(
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        "
        ).build();
        assertThat(board.isWinner(Color.BLACK), is(true));
        assertThat(board.isWinner(Color.WHITE), is(true));
        board = new BoardBuilder().rows(
            "        ",
            "        ",
            "    w   ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        "
        ).build();
        assertThat(board.isWinner(Color.BLACK), is(false));
        assertThat(board.isWinner(Color.WHITE), is(true));
        board = new BoardBuilder().rows(
            "        ",
            "        ",
            "        ",
            "   b    ",
            "        ",
            "        ",
            "        ",
            "        "
        ).build();
        assertThat(board.isWinner(Color.BLACK), is(true));
        assertThat(board.isWinner(Color.WHITE), is(false));
    }

    @Test
    public void testGivenBoardWhenIsBloquedThenTrue() {
        Board board = new BoardBuilder().rows(
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "b b b b ",
            " b b b b",
            "W w w W "
        ).build();
        assertThat(board.isBlocked(Color.WHITE), is(true));
        assertThat(board.isBlocked(Color.BLACK), is(true));
    }

    @Test
    public void testGivenBoardWhenWinThenTrue() {
        Board board = new BoardBuilder().rows(
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            " B      ",
            "        "
        ).build();
        assertThat(board.isWinner(Color.BLACK), is(true));
    }
    
}
