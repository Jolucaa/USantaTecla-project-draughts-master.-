package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.utils.models.ConcreteCoordinate;

import java.util.ArrayList;
import java.util.List;

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

        return (this.color == Color.WHITE && coordinate.getRow() == 0) ||
                (this.color == Color.BLACK && coordinate.getRow() == Coordinate.DIMENSION - 1);
    }

    @Override
    boolean isValidWay(Coordinate origin, Coordinate target) {
        ConcreteCoordinate orthogonalVector = origin.getOrthogonalVector(target);
        return (this.color == Color.BLACK && orthogonalVector.getRow() == 1) ||
                (this.color == Color.WHITE && orthogonalVector.getRow() == -1);
    }

    @Override
    protected List<ConcreteCoordinate> getChildOrthogonalVectors() {
        List<ConcreteCoordinate> orthogonalVectors = new ArrayList<>();
        int vertical = 1;
        if (this.color == Color.WHITE) {
            vertical = -1;
        }
        this.getOrthogonalVectors(orthogonalVectors, vertical);
        return orthogonalVectors;
    }

    @Override
    boolean isNull() {
        return false;
    }

}