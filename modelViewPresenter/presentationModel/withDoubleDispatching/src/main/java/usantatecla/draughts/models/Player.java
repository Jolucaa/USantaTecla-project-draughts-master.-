package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;

public class Player {

    private Color color;
    private Board board;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    void movePiece(Coordinate origin, Coordinate target){
        this.board.movePiece(origin, target);
    }
}
