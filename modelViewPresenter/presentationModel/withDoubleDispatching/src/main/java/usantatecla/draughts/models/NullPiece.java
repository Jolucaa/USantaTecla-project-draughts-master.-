package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
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
    protected boolean isTooFarMove(Coordinate origin, Coordinate target) {
        return true;
    }

    @Override
    protected boolean isTooFarJump(Coordinate origin, Coordinate target) {
        return true;
    }

    @Override
    boolean isNull() {
        return true;
    }

}
