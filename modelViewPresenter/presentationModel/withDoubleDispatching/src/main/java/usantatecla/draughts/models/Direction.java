package usantatecla.draughts.models;

import usantatecla.draughts.types.Coordinate;

enum Direction {
    ;

    private int horizontalShift;
    private int verticalShift;
    
    private Direction(int horizontalShift, int verticalShift) {
        this.horizontalShift = horizontalShift;
        this.verticalShift = verticalShift;
    }


    
    Coordinate getDistanceCoordinate(int distance) {
        int row = this.horizontalShift * distance;
        int column = this.verticalShift * distance;
        return new Coordinate(row, column);
    }

}