/*package usantatecla.draughts.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;
import usantatecla.utils.views.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {

    @Mock
    private Console console;

    private PlayController playController;
    private BoardView boardView;
    private Conversor conversor;

    @BeforeEach
    public void beforeEach() {
        this.boardView = new BoardView();
        this.conversor = new Conversor();
    }

    @Test
    public void testGivenBoardViewWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playController = new PlayController(new GameBuilder().rows(
                    "X  ",
                    " O ",
                    "O X").build(), new State());
            this.boardView.write(this.playController);
            String string = this.conversor.arrayToString(new String[]{
                    "---------------",
                    " | X |   |   | ",
                    " |   | O |   | ",
                    " | O |   | X | ",
                    "---------------"
            });
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, atLeast(0)).writeln(argumentCaptor.capture());
            verify(this.console, atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            this.conversor.reorder(argumentCaptorValues);
            assertThat(string, is(this.conversor.arrayToString(argumentCaptorValues.toArray())));
        }
    }

}
*/