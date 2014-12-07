package views.ui.implementation.swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.persistence.implementation.swing.SwingImageLoader;

public class ApplicationFrame extends JFrame {
    
    private Image image;
    private final String actualImage = "Chrysanthemum.jpg";
    
    public ApplicationFrame () {
        setTitle("Image Viewer");
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        image = readImage();
        createWidget();
        setVisible(true);
    }

    private void createWidget() {
        add(createImagePanel());
    }

    private JPanel createImagePanel() {
       return new JPanel() {
            {
                getContentPane().addComponentListener(createComponentListener());
            }
            
            @Override
            public void paint(Graphics g) {
                super.paint(g); 
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }

            private ComponentListener createComponentListener() {
                return new ComponentListener() {

                    @Override
                    public void componentResized(ComponentEvent e) {
                        revalidate();
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                    }

                    @Override
                    public void componentShown(ComponentEvent e) {
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                    }
                };
            }
            
            
            
        };
    }
    
    private Image readImage() {
        return new SwingImageLoader().load(actualImage);
    }
}
