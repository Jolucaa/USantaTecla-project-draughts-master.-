package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.utils.models.ConcreteCoordinate;

public class Draught extends Piece {

    Draught(Color color) {
        super(color);
    }

    @Override
    protected boolean isTooFarMove(Coordinate origin, Coordinate target) {
        return false;
    }

    @Override
    protected boolean isTooFarJump(Coordinate origin, Coordinate target) {
        return false;
    }

    @Override
    protected boolean isFinalRow(Coordinate coordinate) {
        return false;
    }

    @Override
    boolean isValidWay(Coordinate origin, Coordinate target) {
        return true;
    }

    @Override
    protected List<ConcreteCoordinate> getOrthogonalVectors() {
        List<ConcreteCoordinate> orthogonalVectors = new ArrayList<>();
        orthogonalVectors.add(new ConcreteCoordinate(-1, -1));
        orthogonalVectors.add(new ConcreteCoordinate(-1, 1));
        orthogonalVectors.add(new ConcreteCoordinate(1, 1));
        orthogonalVectors.add(new ConcreteCoordinate(1, -1));
        return orthogonalVectors;
    }

    @Override
    public char getCode() {
        return Character.toUpperCase(super.getCode());
    }

    @Override
    boolean isNull() {
        return false;
    }

}