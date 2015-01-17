
package views.persistence.implementation.swing;

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
        if (currentImage == null) {
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

    public void setNext(Image image) {
        this.next=image;
    }

    public void setPrev(Image image) {
        this.prev=image;
    }
    
}
