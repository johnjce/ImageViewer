
package model;

import java.awt.image.BufferedImage;

public class SwingProxyImage implements Image {
    
    private String filename;
    
    private BufferedImage image;
    
    private Image next;
    private Image prev;

    public SwingProxyImage (String filename) {
        this.filename = filename;
    }
    
    @Override
    public Bitmap getBitmap() {
        return new SwingBitmap(image.getRGB(0, 0, 0, 0, null, 0, 0));
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
