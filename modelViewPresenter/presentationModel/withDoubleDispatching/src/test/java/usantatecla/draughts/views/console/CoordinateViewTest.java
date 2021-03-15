package usantatecla.draughts.views.console;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.draughts.types.Coordinate;
import usantatecla.utils.views.SquareBoundedCoordinateView;
import usantatecla.utils.views.SquareBoundedCoordinateViewTest;

@ExtendWith(MockitoExtension.class)
public class CoordinateViewTest extends SquareBoundedCoordinateViewTest {

    @Override
    public int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public SquareBoundedCoordinateView getCoordinateView() {
        return new CoordinateView();
    }

}
