package views.persistence.implementation.swing;

import java.io.File;
import java.io.FilenameFilter;
import model.Image;
import views.persistence.interfaces.ImageLoader;

public class ListImageLoader implements ImageLoader {
    
    private final String directory;
    
    public ListImageLoader (String directory) {
        this.directory=directory;
    }
    
    @Override
    public Image load() {
        String [] files = new File(directory).list(getFileFilter());
        Image image=new SwingProxyImage(new FileImageLoader(directory+"\\"+files[0]));
        ((SwingProxyImage) image).setNext(new SwingProxyImage(new FileImageLoader(directory+"\\"+files[1])));
        Image prevImage=image;
        Image currentImage = image.getNext();
        for (int i = 1; i < files.length - 1; i++) {
                ((SwingProxyImage) currentImage).setNext(new SwingProxyImage(new FileImageLoader(directory+"\\"+files[i+1])));
                ((SwingProxyImage) currentImage).setPrev(prevImage);
                prevImage=currentImage;
                currentImage=currentImage.getNext();
        }
        ((SwingProxyImage) image).setPrev(currentImage);      
        ((SwingProxyImage) currentImage).setNext(image);
        ((SwingProxyImage) currentImage).setPrev(prevImage);
        return image;
    }
    
    private FilenameFilter getFileFilter () {
        return (File directory, String fileName) -> fileName.endsWith(".jpg");
    }
    
}
