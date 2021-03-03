package usantatecla.utils.models;

public class ConcreteCoordinate implements Coordinate {

	public static final String ROW = "Row: ";
	public static final String COLUMN = "Column: ";
	protected int row;
	protected int column;

	public ConcreteCoordinate() {
	}

	public ConcreteCoordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	//TODO main diagonal to diagonal
	@Override
	public Direction getDirection(Coordinate coordinate) {
		if (this.equals(coordinate)) {
			return Direction.NULL;
		}
		if (this.inHorizontal(coordinate)) {
			return Direction.HORIZONTAL;
		}
		if (this.inVertical(coordinate)) {
			return Direction.VERTICAL;
		}
		if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
			return Direction.MAIN_DIAGONAL;
		}
		if (this.inDiagonal(coordinate)) {
			return Direction.DIAGONAL;
		}
		return Direction.NULL;
	}

	@Override
	public boolean inHorizontal(Coordinate coordinate) {
		if (coordinate.isNull()) {
			return false;
		}
		return this.row == ((ConcreteCoordinate) coordinate).row;
	}

	@Override
	public boolean inVertical(Coordinate coordinate) {
		if (coordinate.isNull()) {
			return false;
		}
		return this.column == ((ConcreteCoordinate) coordinate).column;
	}

	//TODO Revisar
	@Override
	public boolean inDiagonal(Coordinate coordinate) {
		return getVerticalDistance(coordinate) == getHorizontalDistance(coordinate);
	}

	@Override
	public boolean inMainDiagonal() {
		return this.row - this.column == 0;
	}

	public int getVerticalDistance(Coordinate coordinate) {
		assert !coordinate.isNull();

		return Math.abs(this.row - ((ConcreteCoordinate) coordinate).getRow());
	}

	public int getHorizontalDistance(Coordinate coordinate) {
		assert !coordinate.isNull();

		return Math.abs(this.column - ((ConcreteCoordinate) coordinate).getColumn());
	}

	public void sum(Coordinate coordinate) {
		assert !coordinate.isNull();

		this.row += ((ConcreteCoordinate) coordinate).getRow();
		this.column += ((ConcreteCoordinate) coordinate).getColumn();
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
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
		ConcreteCoordinate other = (ConcreteCoordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate (" + row + ", " + column + ")";
	}

}
