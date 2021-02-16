package usantatecla.draughts.types;

public enum Error {

    NOT_EMPTY,
    NOT_OWNER,
    SAME_COORDINATES,
    WRONG_COORDINATES,
    NOT_DIAGONAL,
    NOT_ADVANCED,
    WITHOUT_EATING,
    COLLEAGUE_EATING,
    TOO_MUCH_ADVANCED,
    TOO_MUCH_EATINGS,
    TOO_MUCH_JUMPS,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }

}
