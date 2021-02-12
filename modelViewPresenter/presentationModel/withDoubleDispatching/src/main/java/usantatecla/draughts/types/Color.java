package usantatecla.draughts.types;

import usantatecla.draughts.types.Coordinate;

public enum Color {
    WHITE,
    BLACK;

    private final int[] LIMITS = new int[]{5, 2};

    boolean isInitialRow(final int row){
        switch(this){
            case WHITE:
                return row >= LIMITS[this.ordinal()];
            case BLACK:
                return row <= LIMITS[this.ordinal()];
        }
        return false;
    }

    public static Color getInitialColor(final Coordinate coordinate) {
        if (coordinate.isBlack())
            for(Color color : Color.values())
                if (color.isInitialRow(coordinate.getRow()))
                    return color;
        return null;
    }
	
}