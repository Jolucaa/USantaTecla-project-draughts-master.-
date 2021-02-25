package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    public boolean isFinished() {
        return this.game.isFinished();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public void next() {
        this.game.next();
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public void movePiece(Coordinate origin, Coordinate target) {
        this.game.movePiece(
                new Coordinate(origin.getRow(), origin.getColumn()),
                new Coordinate(target.getRow(), target.getColumn())
        );
    }

    public Error getOriginError(Coordinate coordinate) {
        return this.game.getOriginError(coordinate);
    }

    public Error getTargetError(Coordinate origin, Coordinate target) {
        return this.game.getTargetError(origin, target);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
