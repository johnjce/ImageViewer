package control.implementation;

import control.Command;
import java.awt.event.ActionEvent;
import views.ui.interfaces.ImageViewer;

public class PreviousImageCommand implements Command {

    private ImageViewer imageViewer;
    
    public void setImageViewer (ImageViewer imageViewer) {
        this.imageViewer=imageViewer;
    }
    
    @Override
    public void execute() {
        imageViewer.setImage(imageViewer.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
    
}
