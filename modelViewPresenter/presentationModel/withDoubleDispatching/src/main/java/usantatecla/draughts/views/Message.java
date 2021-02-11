package usantatecla.draughts.views;

public enum Message {

    TITLE("     ------- Draughts -------"),
    COLOR_PARAM("#color"),
    PROMPT(Message.COLOR_PARAM + " move: "),
    CANCEL_FORMAT("-1"),
    WINNER("You've won!!! ;-)"),
    LOST_MESSAGE("You've lost!!! :-("),
    RESUME("Do you want to continue");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
