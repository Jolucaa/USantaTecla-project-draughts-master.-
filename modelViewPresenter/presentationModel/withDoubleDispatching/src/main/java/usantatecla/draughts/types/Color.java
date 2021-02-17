package usantatecla.draughts.types;

public enum Color {

    WHITE,
    BLACK,
    NULL;

    private final int[] LIMITS = new int[]{5, 2};

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    boolean isInitialRow(int row){
        switch(this){
            case WHITE:
                return row >= LIMITS[this.ordinal()];
            case BLACK:
                return row <= LIMITS[this.ordinal()];
        }
        return false;
    }

    public boolean isNull() {
        return this == Color.NULL;
    }
	
}