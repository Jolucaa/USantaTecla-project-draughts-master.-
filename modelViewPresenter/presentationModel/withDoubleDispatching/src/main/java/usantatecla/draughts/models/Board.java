package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Board {

    private Piece[][] pieces;

    Board() {
        this.pieces = new Piece[Coordinate.DIMENSION][Coordinate.DIMENSION];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                Color color = Color.getInitialColor(new Coordinate(i, j));
                Piece piece = Piece.NULL;
                if (!color.isNull()) {
                    piece = new Pawn(color);
                }
                this.pieces[i][j] = piece;
            }
        }
    }

    void movePiece(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !this.isEmpty(origin);
        assert !target.isNull() && this.isEmpty(target);
        assert !origin.equals(target);

        Piece piece = this.getPiece(origin);
        this.putPiece(origin, Piece.NULL);
        if(piece.isFinalRow(target)) {
            piece = new Draught(piece.getColor());
        }
        this.putPiece(target, piece);
        this.removePiecesInBetween(origin, target);
    }

    
    boolean isEmpty(Coordinate coordinate) {
        return this.getPiece(coordinate).isNull();
    }

    void putPiece(Coordinate coordinate, Piece piece) {
        assert !coordinate.isNull();

        this.pieces[coordinate.getRow()][coordinate.getColumn()] = piece;
    }

    private void removePiecesInBetween(Coordinate origin, Coordinate target) {
        Coordinate coordinate = origin.clone();
        coordinate.sum(origin.getOrthogonalVector(target));
        while (!coordinate.equals(target)) {
            this.putPiece(coordinate, Piece.NULL);
            coordinate.sum(origin.getOrthogonalVector(target));
        }
    }

    Piece getPiece(Coordinate coordinate) {
        assert !coordinate.isNull();

        return this.pieces[coordinate.getRow()][coordinate.getColumn()];
    }

    char getCode(Coordinate coordinate) {
        return this.getPiece(coordinate).getCode();
    }

    Error getTargetError(Coordinate origin, Coordinate target) {
        if (!this.isEmpty(target)) {
            return Error.NOT_EMPTY;
        }
        if (this.areColleaguePiecesInBetween(origin, target)){
            return Error.COLLEAGUE_EATING;
        }
        List<Piece> pieces = this.getPiecesInBetween(origin, target);
        if (pieces.size() == 1) {
            return this.getPiece(origin).getJumpTargetError(origin, target);
        } else if (pieces.size() == 0) {
            return this.getPiece(origin).getMoveTargetError(origin, target);
        } else {
            return Error.TOO_MUCH_EATINGS;
        }
    }

    private boolean areColleaguePiecesInBetween(Coordinate origin, Coordinate target) {
        List<Piece> pieces = this.getPiecesInBetween(origin, target);
        for (Piece piece : pieces) {
            if(piece.getColor() == this.getColor(origin)){
                return true;
            }
        }
        return false;
    }

    Color getColor(Coordinate coordinate) {
        return this.getPiece(coordinate).getColor();
    }

    private List<Piece> getPiecesInBetween(Coordinate origin, Coordinate target) {
        List<Piece> pieces = new ArrayList<>();
        Coordinate coordinate = origin.clone();
        coordinate.sum(origin.getOrthogonalVector(target));
        while (!coordinate.equals(target)) {
            if (!this.isEmpty(coordinate)) {
                pieces.add(this.getPiece(coordinate));
            }
            coordinate.sum(origin.getOrthogonalVector(target));
        }
        return pieces;
    }

    boolean isFinished(Color activeColor) {
        return this.isWinner(activeColor) ||
         (this.isBlocked(activeColor) && this.isBlocked(activeColor.opposite()));
    }

    boolean isWinner(Color activeColor) {
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                Color color = this.getPiece(new Coordinate(i, j)).getColor();
                if (color == activeColor.opposite()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBlocked(Color color) {
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                if (!this.isEmpty(coordinate) && !this.isBlocked(coordinate)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBlocked(Coordinate coordinate) {
        Piece piece = this.getPiece(coordinate);
        for (Coordinate coordinateDiagonal : piece.getDiagonalCoordinates(coordinate)) {
            if (this.getTargetError(coordinate, coordinateDiagonal).isNull()) {
                return false;
            }
        }
        return true;
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