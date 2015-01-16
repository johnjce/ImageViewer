package control.implementation;

import control.Command;
import java.awt.event.ActionEvent;
import views.ui.interfaces.ImageViewer;

public class NextImageCommand implements Command {

    private ImageViewer imageViewer;
    
    public NextImageCommand (ImageViewer imageViewer) {
        this.imageViewer=imageViewer;
    }
    
    @Override
    public void execute() {
        imageViewer.setImage(imageViewer.getImage().getNext());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
           execute();
    }
    
}
