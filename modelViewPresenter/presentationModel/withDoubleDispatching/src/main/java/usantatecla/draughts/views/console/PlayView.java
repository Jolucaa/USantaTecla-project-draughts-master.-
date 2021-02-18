package usantatecla.draughts.views.console;

import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.views.Message;

class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().write(playController);
        } while (!playController.isFinished());
        new MessageView().writeln(Message.PLAYER_WIN, playController.getActiveColor().name());
        playController.nextState();
    }

}
