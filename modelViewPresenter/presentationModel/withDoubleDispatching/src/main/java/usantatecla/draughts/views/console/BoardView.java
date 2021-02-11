package usantatecla.draughts.views.console;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Piece;
import usantatecla.utils.views.Console;

class BoardView {

    void write(InteractorController interactorController) {
        assert interactorController != null;
        final int DIMENSION = interactorController.getDimension();
        this.writeNumbersLine(DIMENSION);
        for (int i = 0; i < DIMENSION; i++) {
            this.writePiecesRow(i, interactorController);
        }
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        Console.getInstance().write("   ");
        for (int i = 0; i < DIMENSION; i++)
            Console.getInstance().write((i + 1) + "   ");
        Console.getInstance().writeln();
    }

    private void writePiecesRow(final int row, InteractorController interactorController) {
        Console.getInstance().write((row + 1));
        for (int j = 0; j < interactorController.getDimension(); j++) {
            Console.getInstance().write("|");
            Piece piece = interactorController.getPiece(new Coordinate(row, j));
            if (piece == null)
                Console.getInstance().write("   ");
            else 
                Console.getInstance().write(piece.getCode());
        }
        Console.getInstance().write("|");
        Console.getInstance().writeln((row + 1));
    }

}
