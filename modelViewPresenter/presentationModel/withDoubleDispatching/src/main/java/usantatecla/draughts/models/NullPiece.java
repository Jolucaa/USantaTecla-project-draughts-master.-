package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;

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
    Error isCorrectDiagonalMovement(int amountBetweenDiagonalPieces, int pair, Coordinate... coordinates) {
        return Error.NULL;
    }

    @Override
    boolean isNull() {
        return true;
    }

    @Override
    boolean isValidWay(Coordinate origin, Coordinate target) {
        return false;
    }
}
