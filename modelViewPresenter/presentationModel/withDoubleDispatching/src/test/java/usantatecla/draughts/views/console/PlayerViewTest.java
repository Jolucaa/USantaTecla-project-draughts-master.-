package usantatecla.draughts.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;
import usantatecla.draughts.views.Message;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerViewTest {

    final static Coordinate ORIGIN = new Coordinate(0, 0);
    final static Coordinate TARGET = new Coordinate(0, 1);

    @Mock
    private Console console;

    @Mock
    private PlayController playController;

    private PlayerView playerView;

    @BeforeEach
    public void beforeEach() {
        this.playerView = spy(new PlayerView(this.playController));
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenMoveToken() {
        doReturn(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET).when(playerView).getCoordinate(any());
        when(this.playController.getOriginError(any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.playController.getTargetError(any(Coordinate.class),any(Coordinate.class))).thenReturn(Error.NULL);
        this.playerView.interact();
        verify(this.playController).movePiece(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET);
    }

    @Test
    public void testGivenUserPlayerViewWhenGetCoordinateThenReturn() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(
                    PlayerViewTest.ORIGIN.getRow() + 1,
                    PlayerViewTest.ORIGIN.getColumn() + 1
            );
            assertThat(this.playerView.getCoordinate(Message.COORDINATE_TO_PUT), is(PlayerViewTest.ORIGIN));
        }
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenMoveTokenNotOwnerError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            doReturn(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET).when(this.playerView).getCoordinate(any());
            when(this.playController.getOriginError(any(Coordinate.class))).thenReturn(Error.NOT_OWNER, Error.NULL);
            when(this.playController.getTargetError(any(Coordinate.class),any(Coordinate.class))).thenReturn(Error.NULL);
            this.playerView.interact();
            verify(this.console).writeln("There is not a token of yours");
        }
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenMoveTokenNotEmptyError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            doReturn(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET).when(this.playerView).getCoordinate(any());
            when(this.playController.getOriginError(any(Coordinate.class))).thenReturn(Error.NOT_EMPTY, Error.NULL);
            when(this.playController.getTargetError(any(Coordinate.class),any(Coordinate.class))).thenReturn(Error.NULL);
            this.playerView.interact();
            verify(this.console).writeln("The square is not empty");
        }
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenMoveTokenSameCoordinatesError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            doReturn(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET).when(this.playerView).getCoordinate(any());
            when(this.playController.getOriginError(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.getTargetError(any(Coordinate.class),any(Coordinate.class))).thenReturn(Error.SAME_COORDINATES, Error.NULL);
            this.playerView.interact();
            verify(this.console).writeln("The origin and target squares are the same");
        }
    }

}
