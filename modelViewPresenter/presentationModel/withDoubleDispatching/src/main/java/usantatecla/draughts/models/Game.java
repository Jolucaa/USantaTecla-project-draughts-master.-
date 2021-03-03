package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;

public class Game {

	private Board board;
	private Turn turn;

	public Game() {
		this.board = new Board();
		this.turn = new Turn(this.board);
	}

	public void reset() {
		this.board.reset();
		this.turn.reset();
	}

	public void movePiece(Coordinate origin, Coordinate target){
		this.turn.movePiece(origin, target);
	}

	public Error getOriginError(Coordinate coordinate) {
		return this.turn.getOriginError(coordinate);
	}

	public Error getTargetError(Coordinate origin, Coordinate target){
		return this.turn.getTargetError(origin, target);
	}

	public char getCode(Coordinate coordinate) {
		assert !coordinate.isNull();

		return this.board.getCode(coordinate);
	}

	public boolean isFinished() {
		return this.board.isFinished(this.getActiveColor());
	}

	public boolean isWinner() {
		return this.board.isWinner(this.getActiveColor());
	}

	public Color getActiveColor() {
		return this.turn.getActiveColor();
	}

	public void next() {
		this.turn.next();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		result = prime * result + ((turn == null) ? 0 : turn.hashCode());
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
		Game other = (Game) obj;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		if (turn == null) {
			if (other.turn != null)
				return false;
		} else if (!turn.equals(other.turn))
			return false;
		return true;
	}

}