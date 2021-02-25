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
        Message message = Message.DRAW;
        if (playController.isWinner()){
            message = Message.PLAYER_WIN;
        }
        new MessageView().writeln(message);
        playController.nextState();
    }

}
