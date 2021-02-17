package usantatecla.draughts.types;

public enum Error {

    NOT_EMPTY,
    NOT_OWNER,
    SAME_COORDINATES,
    WRONG_COORDINATES,
    NOT_DIAGONAL,
    NOT_VALID_WAY,
    WITHOUT_EATING,
    COLLEAGUE_EATING,
    TOO_FAR,
    TOO_MUCH_EATINGS,
    TOO_MUCH_JUMPS,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }

}
