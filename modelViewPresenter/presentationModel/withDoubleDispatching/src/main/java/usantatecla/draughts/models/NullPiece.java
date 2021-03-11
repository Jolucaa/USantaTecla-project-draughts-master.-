package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.utils.models.ConcreteCoordinate;

public class NullPiece extends Piece{

    private static NullPiece instance;

    static NullPiece getInstance() {
        if (NullPiece.instance == null) {
            NullPiece.instance = new NullPiece();
        }
        return NullPiece.instance;
    }

    private NullPiece() {
        super(Color.NULL);
    }

    @Override
    boolean isValidWay(Coordinate origin, Coordinate target) {
        return false;
    }

    @Override
    protected List<ConcreteCoordinate> getChildOrthogonalVectors() {
        return new ArrayList<>();
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
    boolean isNull() {
        return true;
    }

}
