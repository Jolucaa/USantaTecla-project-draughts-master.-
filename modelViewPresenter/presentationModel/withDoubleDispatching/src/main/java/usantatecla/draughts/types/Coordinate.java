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
        assert this.di isOnDiagonal(coordinate);
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        final Direction direction = this.getDirection(coordinate);
        Coordinate cursor = this.plus(direction.getDistanceCoordinate(1));
        while (!cursor.equals(coordinate)){
            coordinates.add(cursor);
            cursor = cursor.plus(direction.getDistanceCoordinate(1));
        }
        return coordinates;
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
