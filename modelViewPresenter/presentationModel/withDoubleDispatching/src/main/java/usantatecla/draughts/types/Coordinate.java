package usantatecla.draughts.types;

import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquareBoundedCoordinate;

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

    //TODO mover a utils
    public Coordinate getOrthogonalVector(Coordinate target) {
        return new Coordinate((int) Math.signum(target.getRow() - this.getRow()),
                (int) Math.signum(target.getColumn() - this.getColumn()));
    }

    //TODO mover a utils
    public Coordinate sum(Coordinate coordinate) {
        return new Coordinate(this.getRow()+coordinate.getRow(), this.getColumn()+coordinate.getColumn());
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
