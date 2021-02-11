package usantatecla.draughts.views.console;

import usantatecla.draughts.views.Message;
import usantatecla.utils.views.Console;
//TODO Update messages
public class MessageView {

    public void writeln(Message message) {
        Console.getInstance().writeln(message.toString());
    }

    public void writeln(Message message, int attempts) {

        Console.getInstance().writeln(message.toString().replaceAll("#attempts", "" + attempts));
    }

    public void writeln(Message message, int blacks, int whites) {

        Console.getInstance().writeln(message.toString().replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
    }

}
