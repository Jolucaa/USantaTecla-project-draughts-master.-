package usantatecla.draughts.views;

import usantatecla.draughts.controllers.Controller;
import usantatecla.draughts.controllers.ControllersVisitor;
import usantatecla.draughts.controllers.Logic;

public abstract class View implements ControllersVisitor {

    public void interact(Logic logic) {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this);
        } while (controller != null);
    }

}
