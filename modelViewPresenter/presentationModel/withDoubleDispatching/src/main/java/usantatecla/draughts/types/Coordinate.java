package usantatecla.draughts.types;

import usantatecla.utils.models.ClosedInterval;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquareBoundedCoordinate;

import java.util.ArrayList;
import java.util.List;

public class Coordinate extends SquareBoundedCoordinate {

    public static final int DIMENSION = 8;

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    public Coordinate(ConcreteCoordinate concreteCoordinate) {
        super(concreteCoordinate);
    }

    public Coordinate getOrthogonalVector(Coordinate coordinate) {
		return new Coordinate((int) Math.signum(coordinate.getRow() - this.getRow()),
				(int) Math.signum(coordinate.getColumn() - this.getColumn()));
	}

    public boolean isInitialPiecePosition() {
        return (this.getRow() + this.getColumn()) % 2 != 0;
    }

    //TODO Esto esta que da asco. Te pedimos perdon
    public List<Coordinate> getDiagonalCoordinates(Coordinate orthogonalVector) {
        List<Coordinate> diagonalCoordinates = new ArrayList<>();
        Coordinate coordinate = new Coordinate(this.getRow(), this.getColumn());
        int distance = 0;
        ClosedInterval closedInterval = new ClosedInterval(0, Coordinate.DIMENSION-1);
        while ((closedInterval.isIncluded(coordinate.getColumn()) && closedInterval.isIncluded(coordinate.getRow()))
                && distance < 2) {
            coordinate.sum(orthogonalVector);
            distance++;
            diagonalCoordinates.add(coordinate);
        }
        return diagonalCoordinates;
    }

    @Override
    protected int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (!other.isNull()) {
            if (this.getRow() != other.getRow())
                return false;
            if (this.getColumn() != other.getColumn())
                return false;
        }
        return true;
    }

}
