package usantatecla.draughts.types;

import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.Direction;
import usantatecla.utils.models.SquareBoundedCoordinate;

import java.util.ArrayList;
import java.util.List;

public class Coordinate extends SquareBoundedCoordinate {

    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 7;
    public static final int DIMENSION = UPPER_LIMIT + 1;

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    public Coordinate(ConcreteCoordinate concreteCoordinate) {
        super(concreteCoordinate);
    }

    public List<Coordinate> getBetweenDiagonalCoordinates(Coordinate coordinate){
        assert this.isOnDiagonal(coordinate);
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        final Direction direction = this.getDirection(coordinate);
        ConcreteCoordinate cursor = this.plus(direction.getDistanceCoordinate(1));
        Coordinate cursor1 = new Coordinate(cursor.getRow(), cursor.getColumn());
        while (!cursor.equals(coordinate)){
            coordinates.add(cursor1);
            cursor = cursor1.plus(direction.getDistanceCoordinate(1));
        }
        return coordinates;
    }

    public boolean isBlack() {
        return (this.getRow() + this.getColumn()) % 2 != 0;
    }

    public boolean isLast() {
        return this.getRow() == Coordinate.UPPER_LIMIT;
    }

    public boolean isFirst() {
        return this.getRow() == Coordinate.LOWER_LIMIT;
    }

    @Override
    public int getDimension() {
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
