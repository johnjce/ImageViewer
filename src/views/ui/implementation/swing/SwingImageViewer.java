package views.ui.implementation.swing;

import javax.swing.JPanel;
import model.Image;
import views.ui.interfaces.ImageViewer;

public class SwingImageViewer extends JPanel implements ImageViewer {   
    
    public SwingImageViewer () {
        super();
    }
    
    @Override
    public void update() {
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public void setImage(Image image) {
    }
    
}
