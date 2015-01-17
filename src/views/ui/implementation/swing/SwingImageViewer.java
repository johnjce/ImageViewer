package views.ui.implementation.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;
import views.persistence.implementation.swing.ListImageLoader;
import views.ui.interfaces.ImageViewer;

public class SwingImageViewer extends JPanel implements ImageViewer {   
    
    private static final String DIRECTORY ="C:\\Users\\Public\\Pictures\\Sample Pictures";
    
    private Image image;
    
    private double scale=1;
    private int positionMouse=0;
    
    public SwingImageViewer () {
        super();
        image=linkImages();
        hookEvents();
    }

    @Override
    public Image getImage() {
        return image; 
    }

    @Override
    public void setImage(Image image) {
        this.image=image;
        repaint();
    }

    @Override
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g2d);
        try {
            AffineTransform xform = AffineTransform.getScaleInstance(scale, scale);
            g2d.drawImage(ImageIO.read(new ByteArrayInputStream(image.getBitmap().getPixels())), xform, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        g2d.dispose();
    }

    private Image linkImages() {
        return new ListImageLoader(DIRECTORY).load();
    }

    private void hookEvents() {
        this.addMouseListener(new MouseListener () {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                positionMouse=me.getX();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (positionMouse >= me.getX()) {
                    image=image.getNext();
                } else {
                    image=image.getPrev();
                }
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
            
        });
    }
    
}
