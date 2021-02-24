package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;

public class BoardBuilder {

    private List<String> rows;

    public BoardBuilder() {
        this.rows = new ArrayList<>();
    }

    public BoardBuilder rows(String... rows) {
        assert rows.length == 8;
        for (String row : rows) {
            assert Pattern.matches("[bwBW ]{8}", row);
            this.rows.add(row);
        }
        return this;
    }

    public Board build() {
        Board board = new Board();
        if (!this.rows.isEmpty()) {
            for (int i = 0; i < this.rows.size(); i++) {
                String string = this.rows.get(i);
                for (int j = 0; j < string.length(); j++) {
                    board.putPiece(new Coordinate(i, j), this.getPiece(string.charAt(j)));
                }
            }
        }
        return board;
    }

    private Piece getPiece(char character) {
        switch (character) {
            case 'b':
                return new Pawn(Color.BLACK);
            case 'B':
                return new Draught(Color.BLACK);
            case 'w':
                return new Pawn(Color.WHITE);
            case 'W':
                return new Draught(Color.WHITE);
            default:
                return Piece.NULL;
            }
    }
    
}
