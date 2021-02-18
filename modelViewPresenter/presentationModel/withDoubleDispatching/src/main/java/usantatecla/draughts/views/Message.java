package usantatecla.draughts.views;

public enum Message {

    TITLE("     ------- Draughts -------"),
    COLOR_PARAM("#color"),
    PROMPT(Message.COLOR_PARAM + " move: "),
    CANCEL_FORMAT("-1"),
    WINNER("You've won!!! ;-)"),
    LOST_MESSAGE("You've lost!!! :-("),
    RESUME("Do you want to continue"),

    VERTICAL_LINE(" | "),
    ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:"),
    COORDINATE_TO_PUT("Coordinate to put"),
    COORDINATE_TO_REMOVE("Origin coordinate to move"),
    COORDINATE_TO_MOVE("Target coordinate to move"),
    PLAYER_WIN("#player player: You win!!! :-)");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
