package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;
import usantatecla.utils.models.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Board {

    private Piece[][] pieces;

    Board() {
        this.pieces = new Piece[Coordinate.DIMENSION][Coordinate.DIMENSION];
        for (int i = 0; i < Coordinate.DIMENSION; i++)
            for (int j = 0; j < Coordinate.DIMENSION; j++)
                this.pieces[i][j] = Piece.NULL;
    }

    void reset() {
        for (int i = 0; i < Coordinate.DIMENSION; i++)
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Color color = Color.getInitialColor(coordinate);
                Piece piece = Piece.NULL;
                if (!color.isNull())
                    piece = new Pawn(color);
                this.putPiece(coordinate, piece);
            }
    }

    void movePiece(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !this.isEmpty(origin);
        assert !target.isNull() && this.isEmpty(target);
        assert !origin.equals(target);

        Piece piece = this.getPiece(origin);
        this.putPiece(origin, Piece.NULL);
        this.putPiece(target, piece);
        this.removePiecesInBetween(origin, target);
    }

    private void putPiece(Coordinate coordinate, Piece piece) {
        assert !coordinate.isNull();

        this.pieces[coordinate.getRow()][coordinate.getColumn()] = piece;
    }
    
    private void removePiecesInBetween(Coordinate origin, Coordinate target) {
        while (!origin.equals(target)) {
            origin.sum(origin.getOrthogonalVector(target));
            this.putPiece(origin, Piece.NULL);
        }
    }

    private Piece getPiece(Coordinate coordinate) {
        assert !coordinate.isNull();
        return this.pieces[coordinate.getRow()][coordinate.getColumn()];
    }

    Color getColor(Coordinate coordinate) {
        Piece piece = this.getPiece(coordinate);
        if (piece.isNull())
            return Color.NULL;
        return piece.getColor();
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.getPiece(coordinate).isNull();
    }

    @Override
    public String toString() {
        String string = "";
        string += this.toStringHorizontalNumbers();
        for (int i = 0; i < Coordinate.DIMENSION; i++)
            string += this.toStringHorizontalPiecesWithNumbers(i);
        string += this.toStringHorizontalNumbers();
        return string;
    }

    private String toStringHorizontalNumbers() {
        String string = " ";
        for (int j = 0; j < Coordinate.DIMENSION; j++)
            string += j;
        return string + "\n";
    }

    private String toStringHorizontalPiecesWithNumbers(int row) {
        String string = " " + row;
        for (int j = 0; j < Coordinate.DIMENSION; j++) {
            Piece piece = this.getPiece(new Coordinate(row, j));
            if (piece.isNull())
                string += " ";
            else {
                string += piece;
            }
        }
        return string + row + "\n";
    }

    Error getTargetError(Coordinate origin, Coordinate target) {

        if(this.areColleaguePiecesInBetween(origin, target)){
            return Error.COLLEAGUE_EATING;
        }
        return this.getPiece(origin).getError(origin, target);
    }

    private boolean areColleaguePiecesInBetween(Coordinate origin, Coordinate target) {
        Coordinate coordinate = origin;
        while (!coordinate.equals(target)) {
            coordinate.sum(origin.getOrthogonalVector(target));
            if(this.getColor(coordinate) == this.getColor(origin)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(pieces);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Board other = (Board) obj;
        if (!Arrays.deepEquals(pieces, other.pieces))
            return false;
        return true;
    }

}