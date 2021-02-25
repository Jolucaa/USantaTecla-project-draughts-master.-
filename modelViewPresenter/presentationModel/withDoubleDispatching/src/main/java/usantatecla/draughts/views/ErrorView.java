package usantatecla.draughts.views;

import usantatecla.draughts.types.Error;

public abstract class ErrorView {

    public static final String[] MESSAGES = {
            "The square is not empty",
            "There is not a token of yours",
            "The origin and target squares are the same",
            "The coordinates are wrong",
            "The coordinates are not in diagonal",
            "Your pawn cannot move in this direction",
            "You have to eat the opponent's piece!!!",
            "You cannot eat your pieces",
            "You are trying to move too far",
            "You cannot eat more than one piece",
            "This piece is blocked"
        };

    public abstract void writeln(Error error);

}
