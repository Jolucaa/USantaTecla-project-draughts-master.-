package usantatecla.draughts.views;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.InteractorControllersVisitor;
import usantatecla.draughts.controllers.Logic;

public abstract class View implements InteractorControllersVisitor {

    public void interact(Logic logic) {
        InteractorController interactorController;
        do {
            interactorController = logic.getController();
            if (interactorController != null)
                interactorController.accept(this);
        } while (interactorController != null);
    }

}
