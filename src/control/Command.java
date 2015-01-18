package control;

import java.awt.event.ActionListener;
import views.ui.interfaces.ImageViewer;

public interface Command extends ActionListener {
    public void execute();
    public void setImageViewer(ImageViewer imageViewer);
}
