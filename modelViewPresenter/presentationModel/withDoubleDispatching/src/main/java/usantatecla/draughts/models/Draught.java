package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
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
  public char getCode() {
    return Character.toUpperCase(super.getCode());
  }

  @Override
  boolean isNull() {
    return false;
  }

}