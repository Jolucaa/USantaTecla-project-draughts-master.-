package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;
import usantatecla.utils.models.ConcreteCoordinate;

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
		return getNotValidWayError(origin, target);
	}

	protected abstract boolean isTooFarMove(Coordinate origin, Coordinate target);

	private Error getNotValidWayError(Coordinate origin, Coordinate target) {
		if(!this.isValidWay(origin, target)){
			return Error.NOT_VALID_WAY;
		}
		return Error.NULL;
	}

	abstract boolean isValidWay(Coordinate origin, Coordinate target);

	Error getJumpTargetError(Coordinate origin, Coordinate target) {
		if (this.isTooFarJump(origin, target)) {
			return Error.TOO_FAR;
		}
		return getNotValidWayError(origin, target);
	}
	
	protected abstract boolean isTooFarJump(Coordinate origin, Coordinate target);

	protected abstract boolean isFinalRow(Coordinate coordinate);

	List<Coordinate> getDiagonalCoordinates(Coordinate origin) {
		List<Coordinate> diagonalCoordinates = new ArrayList<>();
		for (ConcreteCoordinate coordinate : this.getChildOrthogonalVectors()) {
			for (Coordinate coordinateDiagonal : origin.getDiagonalCoordinates(coordinate)) {
				diagonalCoordinates.add(coordinateDiagonal);
			}
		}
		return diagonalCoordinates;
	}

	protected abstract List<ConcreteCoordinate> getChildOrthogonalVectors();

	List<ConcreteCoordinate> getOrthogonalVectors(List<ConcreteCoordinate> orthogonalVectors, int vertical) {
		for (int horizontal : new int[]{1, -1}) {
			orthogonalVectors.add(new ConcreteCoordinate(vertical, horizontal));
		}
		return orthogonalVectors;
	}

	Color getColor() {
		return this.color;
	}

	char getCode() {
		return this.color.getInitial();
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