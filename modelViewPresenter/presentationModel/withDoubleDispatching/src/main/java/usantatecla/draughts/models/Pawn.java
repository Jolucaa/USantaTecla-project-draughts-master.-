package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;

public class Pawn extends Piece {

    private static char[] CHARACTERS = {'b', 'n'};
    private static final int MAX_DISTANCE = 2;

    Pawn(Color color) {
        super(color);
    }

    @Override
    Error isCorrectDiagonalMovement(int amountBetweenDiagonalPieces, int pair, Coordinate... coordinates) {
        if (!this.isAdvanced(coordinates[pair], coordinates[pair + 1]))
            return Error.NOT_ADVANCED;
        int distance = coordinates[pair].getDiagonalDistance(coordinates[pair + 1]);
        if (distance > Pawn.MAX_DISTANCE)
            return Error.TOO_MUCH_ADVANCED;
        if (distance == Pawn.MAX_DISTANCE && amountBetweenDiagonalPieces != 1)
            return Error.WITHOUT_EATING;
        return null;
    }

    @Override
    boolean isNull() {
        return false;
    }

    @Override
    boolean isValidWay(Coordinate origin, Coordinate target) {
        Coordinate orthogonalVector = origin.getOrthogonalVector(target);
        if (this.color == Color.BLACK && orthogonalVector.getRow() == 1) {
            return true;
        } else if (this.color == Color.WHITE && orthogonalVector.getRow() == -1) {
            return true;
        }
        return false;
    }

    protected char[] getCodes() {
        return Pawn.CHARACTERS;
    }

}