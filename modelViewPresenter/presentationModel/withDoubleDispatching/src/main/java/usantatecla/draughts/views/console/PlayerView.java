package usantatecla.draughts.views.console;

import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.types.Error;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.views.Message;

class PlayerView {

    private PlayController playController;

    PlayerView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        this.moveToken();
    }

    Coordinate getCoordinate(Message message) {
        assert message != null;

        return (Coordinate) new CoordinateView().read(message.toString());
    }

    private void moveToken() {
        Coordinate origin;
        Error error;
        do {
            origin = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
            error = this.getOriginMoveTokenError(origin);
        } while (error != Error.NULL);
        Coordinate target;
        do {
            target = this.getCoordinate(Message.COORDINATE_TO_MOVE);
            error = this.getTargetMoveTokenError(origin, target);
        } while (error != Error.NULL);
        this.playController.movePiece(origin, target);
    }

    private Error getOriginMoveTokenError(Coordinate origin) {
        assert !origin.isNull();

        Error error = this.playController.getOriginError(origin);
        new ErrorView().writeln(error);
        return error;
    }

    private Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !target.isNull();

        Error error = this.playController.getTargetError(origin, target);
        new ErrorView().writeln(error);
        return error;
    }
    
}
