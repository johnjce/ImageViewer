package views.persistence.implementation.swing;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import views.persistence.interfaces.ImageLoader;

public class SwingImageLoader implements ImageLoader {

    @Override
    public Image load(String filename) {
        try {
            return ImageIO.read(new File("C:\\Users\\Victor\\Documents\\NetBeansProjects\\ImageViewer\\images\\"+filename));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
