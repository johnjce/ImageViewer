
package model.implementation;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Bitmap;
import model.Image;
import views.persistence.interfaces.ImageLoader;

public class SwingProxyImage implements Image {
    
    private ImageLoader loader;
    
    private Image next;
    private Image prev;
    private Image currentImage;

    public SwingProxyImage (ImageLoader loader) {
        this.loader = loader;
    }
    
    @Override
    public Bitmap getBitmap() {
        if (currentImage != null) {
            currentImage = loader.load();
        }
        return currentImage.getBitmap();
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
