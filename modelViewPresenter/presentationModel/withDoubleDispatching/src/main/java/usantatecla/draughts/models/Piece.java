package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Error;
import usantatecla.draughts.types.Coordinate;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

	public static Piece NULL = NullPiece.getInstance();

	protected Color color;

	Piece(Color color) {
		assert color != null;
		this.color = color;
	}

	abstract boolean isNull();

	Error getMoveTargetError(Coordinate origin, Coordinate target) {
		if (this.isTooFarMove(origin, target)) {
			return Error.TOO_FAR;
		}
		return getTargetError(origin, target);
	}

	protected abstract boolean isTooFarMove(Coordinate origin, Coordinate target);

	Error getJumpTargetError(Coordinate origin, Coordinate target) {
		if (this.isTooFarJump(origin, target)) {
			return Error.TOO_FAR;
		}
		return getTargetError(origin, target);
	}

	protected abstract boolean isTooFarJump(Coordinate origin, Coordinate target);

	protected abstract boolean isFinalRow(Coordinate coordinate);

	private Error getTargetError(Coordinate origin, Coordinate target){
		if(!this.isValidWay(origin, target)){
			return Error.NOT_VALID_WAY;
		}
		return Error.NULL;
	}

	abstract boolean isValidWay(Coordinate origin, Coordinate target);

	List<Coordinate> getDiagonalCoordinates(Coordinate origin) {
		List<Coordinate> diagonalCoordinates = new ArrayList<>();
		for (Coordinate coordinate : this.getOrthogonalVectors()) {
			for (Coordinate coordinateDiagonal:origin.getDiagonalCoordinates(coordinate)) {
				diagonalCoordinates.add(coordinateDiagonal);
			}
		}
		return diagonalCoordinates;
	}
	//TODO Revisar nombre
	protected abstract List<Coordinate> getOrthogonalVectors();

	public Color getColor() {
		return this.color;
	}

	public char getCode() {
		return this.color.getInitial();
	}

	@Override
	public String toString() {
		return String.valueOf(this.getCode());
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
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		return true;
	}

}