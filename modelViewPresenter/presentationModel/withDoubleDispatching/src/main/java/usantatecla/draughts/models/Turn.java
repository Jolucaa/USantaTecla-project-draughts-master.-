package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;

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
    if (!this.board.isFinished(this.getActiveColor())) {
      this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }
  }

  Player getActivePlayer() {
    return this.players[this.activePlayer];
  }

  Color getActiveColor() {
    return this.getActivePlayer().getColor();
  }

  void movePiece(Coordinate origin, Coordinate target){
    this.getActivePlayer().movePiece(origin, target);
  }

  /*Turn() {
    this.color = Color.WHITE;
  }

  void reset(){
    if (this.getColor() != Color.WHITE)
      this.change();
  }

  void change() {
    this.color = this.getOppositeColor();
  }

  Color getColor() {
    return this.color;
  }

  Color getOppositeColor() {
    return Color.values()[(this.color.ordinal() + 1) % 2];
  }

  @Override
  public String toString() {
    return this.color.name();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Turn other = (Turn) obj;
    if (color != other.color)
      return false;
    return true;
  }*/

}