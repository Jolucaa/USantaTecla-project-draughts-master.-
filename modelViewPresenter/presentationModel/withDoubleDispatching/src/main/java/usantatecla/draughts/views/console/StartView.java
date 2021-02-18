package usantatecla.draughts.views.console;

import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.views.Message;

class StartView{

    void interact(StartController startController) {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(startController);
        startController.nextState();
    }

}
