package views.ui.implementation.swing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;
import views.ui.interfaces.ImageViewer;

public class SwingImageViewer extends JPanel implements ImageViewer {   
   
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
       try {
             this.image=image;
        update();
    }
    
             g.drawImage(im, im.getHeight(), im.getWidth(), null);
        } catch (IOException ex) {
            Logger.getLogger(SwingImageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
   public void paint (Graphics g) {
        BufferedImage im = ImageIO.read(new ByteArrayInputStream(image.getBitmap().getByteArray()));
        g.drawImage(im, im.getHeight(), im.getWidth(), null);
    }
    
}
