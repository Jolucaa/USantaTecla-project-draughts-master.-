package usantatecla.draughts.views.graphics;

import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.views.View;

public class GraphicsView extends View {

    @Override
    public void visit(StartController startController) {
    }

    @Override
    public void visit(PlayController playController) {
    }

    @Override
    public boolean visit(ResumeController resumeController) {
        return true;
    }

}
