
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SwingProxyImage implements Image {
    
    private String filename;
    
    private Image next;
    private Image prev;

    public SwingProxyImage (String filename) {
        this.filename = filename;
    }
    
    @Override
    public Bitmap getBitmap() {
        try {
            return new SwingBitmap(ImageIO.read(new File(filename)).get);
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
