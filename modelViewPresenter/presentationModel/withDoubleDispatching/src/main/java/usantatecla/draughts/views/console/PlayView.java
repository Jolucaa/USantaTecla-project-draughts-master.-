package usantatecla.draughts.views.console;

import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Error;
import usantatecla.draughts.views.Message;
import usantatecla.utils.views.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class PlayView {
    //TODO enviar a Message
    private static final String[] COLOR_VALUES = { "Whites", "Blacks" };
    private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";

    private String string;

    PlayView() {
        super();
    }

    void interact(PlayController playController) {
        assert playController != null;
        Error error;
        do {
            error = null;
            this.string = this.read(playController.getColor());
            if (this.isCanceledFormat())
                playController.cancel();
            else if (!this.isMoveFormat()) {
                error = Error.BAD_FORMAT;
                this.writeError();
            } else {
                error = playController.move(this.getCoordinates());
                new BoardView().write(playController);
                if (error == null && playController.isBlocked())
                    this.writeLost();
            }
        } while (error != null);
    }

    private String read(Color color) {
        final String titleColor = Message.PROMPT.toString().replace(Message.COLOR_PARAM.toString() ,PlayView.COLOR_VALUES[color.ordinal()]);
        return Console.getInstance().readString(titleColor);
    }

    private boolean isCanceledFormat() {
        return string.equals(Message.CANCEL_FORMAT);
    }

    private boolean isMoveFormat() {
        return Pattern.compile(PlayView.MOVEMENT_FORMAT).matcher(string).find();
    }

    private void writeError(){
        new ErrorView().writeln(usantatecla.draughts.types.Error.ERROR);
    }

    private Coordinate[] getCoordinates() {
        assert this.isMoveFormat();
        List<Coordinate> coordinateList = new ArrayList<>();
        while (string.length() > 0){
            coordinateList.add(Coordinate.getInstance(string.substring(0, 2)));
            string = string.substring(2, string.length());
            if (string.length() > 0 && string.charAt(0) == '.')
                string = string.substring(1, string.length());
        }
        Coordinate[] coordinates = new Coordinate[coordinateList.size()];
        for(int i=0; i< coordinates.length; i++){
            coordinates[i] = coordinateList.get(i);
        }
        return coordinates;
    }

    private void writeLost() {
        Console.getInstance().writeln(Message.LOST_MESSAGE.toString());
    }

}