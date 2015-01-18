package app;

import control.Command;
import control.implementation.NextImageCommand;
import control.implementation.PreviousImageCommand;
import views.ui.implementation.swing.ApplicationFrame;

public class App {
    public static void main (String args []) {
        ApplicationFrame frame = new ApplicationFrame();
        frame.register(new Command [] {new NextImageCommand(), new PreviousImageCommand()});
        frame.setVisible(true);
    }
}
