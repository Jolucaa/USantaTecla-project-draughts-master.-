package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.types.Coordinate;

public abstract class Controller {

    protected Game game;
    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
    }

    public char getCode(Coordinate coordinate) {
        return this.game.getCode(coordinate);
    }

    public abstract void accept(ControllersVisitor controllersVisitor);

}
