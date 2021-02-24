package usantatecla.draughts.types;

import usantatecla.utils.models.ClosedInterval;

public enum Color {

    WHITE,
    BLACK,
    NULL;

    static final ClosedInterval BLACK_ROWS_INTERVAL = new ClosedInterval(0,2);
    static final ClosedInterval WHITE_ROWS_INTERVAL = new ClosedInterval(5,7);

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public static Color getInitialColor(Coordinate coordinate) {
        if(coordinate.isInitialPiecePosition()) {
            if (BLACK_ROWS_INTERVAL.isIncluded(coordinate.getRow()))
                return Color.BLACK;
            if (WHITE_ROWS_INTERVAL.isIncluded(coordinate.getRow()))
                return Color.WHITE;
        }
        return Color.NULL;
    }

    public char getInitial() {
        if(this.isNull()) {
            return ' ';
        }
        return this.name().toLowerCase().charAt(0);
    }

    public Color opposite() {
        assert !this.isNull();

		if(this.equals(Color.BLACK)){
            return Color.WHITE;
        }
        return Color.BLACK;
	}

    public boolean isNull() {
        return this == Color.NULL;
    }
	
}