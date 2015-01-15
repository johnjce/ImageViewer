
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import views.persistence.interfaces.ImageLoader;

public class SwingProxyImage implements Image {
    
    private ImageLoader loader;
    private String filename;
    
    private BufferedImage image;
    
    private Image next;
    private Image prev;

    public SwingProxyImage (ImageLoader loader, String filename) {
        this.loader = loader;
        this.filename= filename;
    }
    
    @Override
    public Bitmap getBitmap() {
        try {
            image = ImageIO.read(new File(filename));
            return new SwingBitmap(image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth()));
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }
    
}
