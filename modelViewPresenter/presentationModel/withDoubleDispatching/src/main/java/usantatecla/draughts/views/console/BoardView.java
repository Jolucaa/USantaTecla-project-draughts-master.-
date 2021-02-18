package usantatecla.draughts.views.console;

import usantatecla.draughts.controllers.Controller;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.views.Message;
import usantatecla.utils.views.Console;

class BoardView {

    void write(Controller controller) {
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                Console.getInstance().write(controller.getCode(new Coordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
    }

}
