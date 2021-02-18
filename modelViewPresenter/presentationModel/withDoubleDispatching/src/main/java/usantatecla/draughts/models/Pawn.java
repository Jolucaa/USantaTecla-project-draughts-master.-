package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;

public class Pawn extends Piece {

    private static final int MAX_MOVE_DISTANCE = 1;
    private static final int MAX_JUMP_DISTANCE = 2;

    Pawn(Color color) {
        super(color);
    }

    @Override
    protected boolean isTooFarMove(Coordinate origin, Coordinate target) {
        return origin.getVerticalDistance(target) > Pawn.MAX_MOVE_DISTANCE;
    }

    @Override
    protected boolean isTooFarJump(Coordinate origin, Coordinate target) {
        return origin.getVerticalDistance(target) > Pawn.MAX_JUMP_DISTANCE;
    }

    @Override
    protected boolean isFinalRow(Coordinate coordinate) {
        assert !this.color.isNull();

        return (this.color == Color.BLACK && coordinate.getRow() == 0) ||
                (this.color == Color.WHITE && coordinate.getRow() == Coordinate.DIMENSION - 1);
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

    @Override
    boolean isNull() {
        return false;
    }

}