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

    public Direction getDirection(SquareBoundedCoordinate coordinate) {
        if (this.equals(coordinate) || this.isNull() || coordinate.isNull()) {
            return Direction.NULL;
        }
        return this.adaptee.getDirection(coordinate.adaptee);
    }

    public int getVerticalDistance(SquareBoundedCoordinate coordinate) {
		assert !adaptee.isNull();

		return ((ConcreteCoordinate) this.adaptee).getVerticalDistance(new ConcreteCoordinate(coordinate.getRow(), coordinate.getColumn()));
	}

    public void sum(ConcreteCoordinate coordinate) {
        assert !this.adaptee.isNull();

        ((ConcreteCoordinate) this.adaptee).sum(new ConcreteCoordinate(coordinate.getRow(), coordinate.getColumn()));
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
