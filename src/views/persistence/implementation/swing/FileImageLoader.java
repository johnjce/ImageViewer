package views.persistence.implementation.swing;

import model.Image;
import views.persistence.interfaces.ImageLoader;

public class FileImageLoader implements ImageLoader {

    @Override
    public Image load(String filename) {
        return new SwingProxyImage();
    }
}
