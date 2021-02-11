package usantatecla.draughts.views.console;

import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.views.Message;
import usantatecla.utils.views.YesNoDialog;

class ResumeView {

    public boolean interact(ResumeController resumeController) {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            resumeController.reset();
        }else{
            resumeController.nextState();
        }
        return yesNoDialog.isAffirmative();
    }

}
