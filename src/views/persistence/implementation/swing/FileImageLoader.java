package views.persistence.implementation.swing;

import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Image;
import model.implementation.RealImage;
import model.implementation.SwingBitmap;
import views.persistence.interfaces.ImageLoader;

public class FileImageLoader implements ImageLoader {
    
    private String filename;
    
    public FileImageLoader (String filename) {
        this.filename=filename;
    }

    public Image load() {
        try {
            return new RealImage(new SwingBitmap(((DataBufferByte) ImageIO.read(new File(filename)).getRaster().getDataBuffer()).getData()));
        } catch (IOException ex) {
            return null;
        }
    }
}
