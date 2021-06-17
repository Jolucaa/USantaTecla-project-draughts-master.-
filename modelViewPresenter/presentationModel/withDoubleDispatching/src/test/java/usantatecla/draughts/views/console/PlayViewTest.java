package usantatecla.draughts.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private Console console;

    @Mock
    private PlayController playController;


    private PlayView playView;

    @BeforeEach
    public void beforeEach(){
        this.playView = new PlayView();
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.playController.getCode(any(Coordinate.class))).thenReturn(Color.WHITE.getInitial());
            doReturn(true).when(this.playController).isFinished();
            doReturn(true).when(this.playController).isWinner();
            when(this.playController.getOriginError(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.getTargetError(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
            this.playView.interact(this.playController);
            verify(this.playController).next();
            verify(this.console).writeln("#player player: You win!!! :-)");
        }
    }

}
