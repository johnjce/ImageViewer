package views.ui.implementation.swing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import model.Image;
import views.ui.interfaces.ImageViewer;

public class SwingImageViewer extends JPanel implements ImageViewer {   
    
    private BufferedImage nextImage;
    private BufferedImage prevImage;
    private BufferedImage actualImage;
    
    private Image image;
    
    public SwingImageViewer () {
        super();
    }
    
    @Override
    public void update() {
        this.repaint();
    }

    @Override
    public Image getImage() {
        return image; 
    }

    @Override
    public void setImage(Image image) {
        this.image=image;
        update();
    }
    
    public void paint (Graphics g) {
        
    }
    
}
