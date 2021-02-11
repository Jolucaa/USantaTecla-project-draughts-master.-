package usantatecla.draughts.views;

import usantatecla.draughts.types.Error;

public abstract class ErrorView {

    public static final String[] MESSAGES = {
            "Error!!! Incorrect format"
        };

    public abstract void writeln(Error error);

}
