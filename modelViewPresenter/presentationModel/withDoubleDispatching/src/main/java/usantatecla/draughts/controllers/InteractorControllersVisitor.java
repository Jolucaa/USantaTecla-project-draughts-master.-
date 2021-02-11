package usantatecla.draughts.controllers;

public interface InteractorControllersVisitor {
	
	void visit(StartController startController);
	void visit(PlayController playController);
	boolean visit(ResumeController resumeController);
}