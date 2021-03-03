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

    //TODO refactor
    @Override
    protected List<ConcreteCoordinate> getOrthogonalVectors() {
        List<ConcreteCoordinate> orthogonalVectors = new ArrayList<>();
        for (int vertical : new int[]{1, -1}) {
            for (int horizontal : new int[]{1, -1}) {
                orthogonalVectors.add(new ConcreteCoordinate(vertical, horizontal));
            }
        }
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