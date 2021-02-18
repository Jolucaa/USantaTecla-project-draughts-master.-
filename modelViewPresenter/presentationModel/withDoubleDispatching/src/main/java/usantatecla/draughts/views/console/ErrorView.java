package usantatecla.draughts.views.console;

import usantatecla.draughts.types.Error;
import usantatecla.utils.views.Console;

class ErrorView extends usantatecla.draughts.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
