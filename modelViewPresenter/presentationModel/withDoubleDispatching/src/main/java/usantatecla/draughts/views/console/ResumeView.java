package usantatecla.draughts.views.console;

import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.views.Message;
import usantatecla.utils.views.YesNoDialog;

class ResumeView {

    boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();
    }

}
