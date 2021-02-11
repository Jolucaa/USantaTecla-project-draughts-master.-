package usantatecla.draughts;

import usantatecla.draughts.views.View;
import usantatecla.draughts.views.graphics.GraphicsView;

class GraphicsDraughts extends Draughts{

    @Override
    protected View createView() {
        return new GraphicsView();
    }

    public static void main(String[] args) {
        new GraphicsDraughts().play();
    }
    
}
