package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;

class Turn {

  private Board board;
  public static final int NUMBER_PLAYERS = 2;
  private Player[] players;
  private int activePlayer;

  Turn(Board board) {
    assert board != null;
    this.board = board;
    this.players = new Player[Turn.NUMBER_PLAYERS];
    this.reset();
  }

  void reset() {
    for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
      this.players[i] = new Player(Color.get(i), this.board);
    }
    this.activePlayer = 0;
  }

  void next() {
    if (!this.board.isWinner(this.getActiveColor())) {
      this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }
  }

  Player getActivePlayer() {
    return this.players[this.activePlayer];
  }

  Color getActiveColor() {
    return this.getActivePlayer().getColor();
  }

  void movePiece(Coordinate origin, Coordinate target) {
    this.getActivePlayer().movePiece(origin, target);
  }

  Error getOriginError(Coordinate coordinate) {
    return this.getActivePlayer().getOriginError(coordinate);
  }

  Error getTargetError(Coordinate origin, Coordinate target) {
    return this.getActivePlayer().getTargetError(origin, target);
  }

}