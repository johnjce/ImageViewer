package views.ui.implementation.swing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;
import model.implementation.SwingProxyImage;
import views.persistence.implementation.swing.FileImageLoader;
import views.ui.interfaces.ImageViewer;

public class SwingImageViewer extends JPanel implements ImageViewer {   
    
    private static final String PATH ="C:\\Users\\Public\\Pictures\\Sample Pictures";
    
    private Image image;
    
    private BufferedImage actualImage;
    
    public SwingImageViewer () {
        super();
        linkImages();
    }
    
    @Override
    public void update() {
        this.repaint();
    }

    @Override
    public Image getImage() {
        return image; 
    }

    @Override
    public void setImage(Image image) {
        this.image=image;
        update();
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        try {   
            g.drawImage(ImageIO.read(new ByteArrayInputStream(image.getBitmap().getPixels())), 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(SwingImageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void linkImages() {
        String [] files = new File(PATH).list(getFileFilter());
        image=new SwingProxyImage(new FileImageLoader(PATH+"\\"+files[0]));
        ((SwingProxyImage) image).setNext(new SwingProxyImage(new FileImageLoader(PATH+"\\"+files[1])));
        Image currentImage = image;
        for (int i = 0; i < files.length - 1 ; i++) {
            ((SwingProxyImage) currentImage).setNext(new SwingProxyImage(new FileImageLoader(PATH+"\\"+files[i+1])));
            currentImage=currentImage.getNext();
        }
        ((SwingProxyImage) currentImage).setNext(image);
        for (int i = files.length - 1; i > 0 ; i--) {
            ((SwingProxyImage) currentImage).setPrev(new SwingProxyImage(new FileImageLoader(PATH+"\\"+files[i-1])));
            currentImage=currentImage.getPrev();
        }
        ((SwingProxyImage) image).setPrev(currentImage);
    }
    
    private FilenameFilter getFileFilter () {
        return new FilenameFilter() {
            @Override
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".jpg");
            }
        };
    }
    
}
