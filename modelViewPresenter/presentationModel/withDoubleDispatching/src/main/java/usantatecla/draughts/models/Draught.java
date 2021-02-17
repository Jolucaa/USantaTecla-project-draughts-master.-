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
  boolean isValidWay(Coordinate origin, Coordinate target) {
    return true;
  }

  @Override
  public String getCode() {
    return super.getCode().toUpperCase();
  }

  @Override
  boolean isNull() {
    return false;
  }

}