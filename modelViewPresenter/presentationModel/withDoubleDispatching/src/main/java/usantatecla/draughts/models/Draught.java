package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Draught extends Piece {

    Draught(Color color) {
        super(color);
    }

    @Override
    protected boolean isTooFarMove(Coordinate origin, Coordinate target) {
        return true;
    }

    @Override
    protected boolean isTooFarJump(Coordinate origin, Coordinate target) {
        return true;
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
    protected List<Coordinate> getOrthogonalVectors() {
        List<Coordinate> orthogonalVectors = new ArrayList<>();
        orthogonalVectors.add(new Coordinate(-1, -1));
        orthogonalVectors.add(new Coordinate(-1, 1));
        orthogonalVectors.add(new Coordinate(1, 1));
        orthogonalVectors.add(new Coordinate(1, -1));
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