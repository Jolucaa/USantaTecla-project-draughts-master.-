package usantatecla.utils.models;

import java.util.Random;

public abstract class SquareBoundedCoordinate {

    private Coordinate adaptee;

    public SquareBoundedCoordinate() {
        this(NullCoordinate.getInstance());
    }

    public SquareBoundedCoordinate(Coordinate coordinate) {
        this.adaptee = coordinate;
    }

    public boolean isNull() {
        return this.adaptee.isNull();
    }

    public SquareBoundedCoordinate(int row, int column) {
        this.adaptee = new ConcreteCoordinate(row, column);

        assert this.isValid();
    }

    public boolean isValid() {
        assert !this.adaptee.isNull();

        ConcreteCoordinate concreteCoordinate = (ConcreteCoordinate) this.adaptee;
        return this.getLimits().isIncluded(concreteCoordinate.getRow())
                && this.getLimits().isIncluded(concreteCoordinate.getColumn());
    }

    public ClosedInterval getLimits() {
        return new ClosedInterval(0, this.getDimension() - 1);
    }

    protected abstract int getDimension();

    /*public Direction getDirection(SquareBoundedCoordinate coordinate) { //TODO
        if (this.equals(coordinate) || this.isNull() || coordinate.isNull()) {
            return Direction.NULL;
        }
        if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
            return Direction.INVERSE_DIAGONAL;
        }
        return this.adaptee.getDirection(coordinate.adaptee);
    }*/

    public boolean inInverseDiagonal() {
        ConcreteCoordinate coordinate = (ConcreteCoordinate) this.adaptee;
        return coordinate.getRow() + coordinate.getColumn() == this.getDimension() - 1;
    }

    protected Direction getDirection(SquareBoundedCoordinate coordinate) {
        assert coordinate != null;
        ConcreteCoordinate substract = this.substract(this);
        for (Direction direction : Direction.values())
            if (direction.isOnDirection(substract))
                return direction;
        return null;
    }

    private ConcreteCoordinate substract(SquareBoundedCoordinate squareBoundedCoordinate) {
        ConcreteCoordinate coordinate = (ConcreteCoordinate) this.adaptee;
        return new ConcreteCoordinate(coordinate.getRow() - squareBoundedCoordinate.getRow(), coordinate.getColumn() - squareBoundedCoordinate.getColumn());
    }

    protected ConcreteCoordinate plus(SquareBoundedCoordinate coordinate) {
        return new ConcreteCoordinate(this.getRow() + coordinate.getRow(), this.getColumn() + coordinate.getColumn());
    }

    public boolean isOnDiagonal(SquareBoundedCoordinate coordinate) {
        return this.getDirection(coordinate) != null;
    }

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        this.adaptee = new ConcreteCoordinate(random.nextInt(this.getDimension()), random.nextInt(this.getDimension()));
    }

    public int getRow() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getRow();
    }

    public int getColumn() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getColumn();
    }

}
