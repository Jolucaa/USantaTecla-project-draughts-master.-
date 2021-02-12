package usantatecla.utils.models;

public enum Direction {

	VERTICAL(0, 1),
	HORIZONTAL(1, 0),
	//MAIN_DIAGONAL, NE o SW
	//INVERSE_DIAGONAL, SE o NW
	NE(1, 1),
	SE(-1, 1),
	SW(-1, -1),
	NW(1, -1),
	NULL(0,0);//TODO Ver si esta bien

	private int horizontalShift;
	private int verticalShift;

	Direction(int horizontalShift, int verticalShift) {
		this.horizontalShift = horizontalShift;
		this.verticalShift = verticalShift;
	}

	public boolean isNull() {
		return this == Direction.NULL;
	}

	public boolean isOnDirection(ConcreteCoordinate coordinate) {
		if (Math.abs(coordinate.getRow()) != Math.abs(coordinate.getColumn()))
			return false;
		if (coordinate.getRow()==0)
			return false;
		if (horizontalShift * coordinate.getRow() < 0)
			return false;
		if (verticalShift * coordinate.getColumn() < 0)
			return false;
		return true;
	}

}
