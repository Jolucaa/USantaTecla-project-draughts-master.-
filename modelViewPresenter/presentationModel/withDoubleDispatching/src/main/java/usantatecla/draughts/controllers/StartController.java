package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

public class StartController extends InteractorController {

	public StartController(Game game, State state) {
        super(game, state);
	}

	public void start() {
        this.state.next();
	}
    
    @Override
	public void accept(InteractorControllersVisitor interactorControllersVisitor) {
		assert interactorControllersVisitor != null;
		interactorControllersVisitor.visit(this);
    }

}
