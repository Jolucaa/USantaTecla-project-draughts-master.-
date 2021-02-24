package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.utils.models.ConcreteCoordinate;

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
    protected List<ConcreteCoordinate> getOrthogonalVectors () {
        List<ConcreteCoordinate> orthogonalVectors = new ArrayList<>();
        if (this.color == Color.WHITE){
            orthogonalVectors.add(new ConcreteCoordinate(-1, -1));
            orthogonalVectors.add( new ConcreteCoordinate(-1, 1));
        }else if (this.color == Color.BLACK) {
            orthogonalVectors.add(new ConcreteCoordinate(1, 1));
            orthogonalVectors.add( new ConcreteCoordinate(1, -1));
        }
        return orthogonalVectors;
    }

    @Override
    boolean isNull() {
        return false;
    }

}