package usantatecla.draughts.views;

import usantatecla.draughts.types.Error;

public abstract class ErrorView {

    public static final String[] MESSAGES = {
            "NOT_EMPTY",
            "NOT_OWNER",
            "SAME_COORDINATES",
            "WRONG_COORDINATES",
            "NOT_DIAGONAL",
            "NOT_VALID_WAY",
            "WITHOUT_EATING",
            "COLLEAGUE_EATING",
            "TOO_FAR",
            "TOO_MUCH_EATINGS",
            "TOO_MUCH_JUMPS",
            "BAD_FORMAT",
            "BLOCKED_PIECE",
            "NULL"
        };

    public abstract void writeln(Error error);

}
