package usantatecla.draughts;

import usantatecla.draughts.controllers.Logic;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.views.View;

public abstract class Draughts {
    
    private View view;
    private Logic logic;

    protected Draughts(){
        this.logic = new Logic(new Game());
        this.view = this.createView();
    }

    protected abstract View createView();

    void play() {
        this.view.interact(this.logic);
    }

}