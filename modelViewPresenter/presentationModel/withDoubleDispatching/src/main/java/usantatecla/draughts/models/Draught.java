package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;

public class Draught extends Piece {

  Draught(Color color) {
    super(color);
  }

  @Override
  Error isCorrectDiagonalMovement(int amountBetweenDiagonalPieces, int pair, Coordinate... coordinates) {
    if (amountBetweenDiagonalPieces > 1)
      return Error.TOO_MUCH_EATINGS;
    return null;
  }

  @Override
  boolean isNull() {
    return false;
  }

  @Override
  boolean isValidWay(Coordinate origin, Coordinate target) {
    return true;
  }

  @Override
  public String getCode(){
		return super.getCode().toUpperCase();
  }

}