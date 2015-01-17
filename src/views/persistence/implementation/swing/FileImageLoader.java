package views.persistence.implementation.swing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import model.Image;
import model.implementation.RealImage;
import views.persistence.interfaces.ImageLoader;

public class FileImageLoader implements ImageLoader {
    
    private final String filename;
    
    public FileImageLoader (String filename) {
        this.filename=filename;
    }

    @Override
    public Image load() {
        try {
            return new RealImage(new SwingBitmap(Files.readAllBytes(new File(filename).toPath())));
        } catch (IOException ex) {
            return null;
        }
    }
}
