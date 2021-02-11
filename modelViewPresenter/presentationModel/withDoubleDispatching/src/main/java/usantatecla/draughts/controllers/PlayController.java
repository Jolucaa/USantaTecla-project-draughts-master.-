package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Error;

public class PlayController extends InteractorController {

	private CancelController cancelController;
	private MoveController moveController;

	public PlayController(Game game, State state) {
		super(game, state);
		this.cancelController = new CancelController(game, state);
		this.moveController = new MoveController(game, state);
	}

	public Error move(Coordinate... coordinates) {
		return this.moveController.move(coordinates);
	}

	public void cancel() {
		this.cancelController.cancel();
	}

	public Color getColor() {
		return this.game.getTurnColor();
	}

	public boolean isBlocked() {
		return this.game.isBlocked();
	}

	@Override
	public void accept(InteractorControllersVisitor interactorControllersVisitor) {
		assert interactorControllersVisitor != null;
		interactorControllersVisitor.visit(this);
	}

}