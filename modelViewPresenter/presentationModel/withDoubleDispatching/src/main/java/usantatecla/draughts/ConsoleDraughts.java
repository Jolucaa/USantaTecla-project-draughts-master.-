package usantatecla.draughts;

import usantatecla.draughts.views.View;
import usantatecla.draughts.views.console.ConsoleView;

class ConsoleDraughts extends Draughts{

    @Override
    protected View createView() {
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new ConsoleDraughts().play();
    }
    
}
