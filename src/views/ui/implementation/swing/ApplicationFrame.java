package views.ui.implementation.swing;

import control.implementation.NextImageCommand;
import control.implementation.PreviousImageCommand;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private SwingImageViewer imageViewer;
    private JPanel panelButton;
    
    public ApplicationFrame () {
        super(" Image Viewer ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1030,800));
        setResizable(false);
        createWidget();
        setVisible(true);
    }

    private void createWidget() {
        add(createImageViewer(), BorderLayout.CENTER);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private JPanel createImageViewer() {
        imageViewer = new SwingImageViewer();
        return imageViewer;
    }

    private JPanel createButtons() {
        panelButton = new JPanel();
        JButton next = new JButton("Next");
        next.addActionListener(new NextImageCommand(imageViewer));
        JButton previous = new JButton("Previous");
        previous.addActionListener(new PreviousImageCommand(imageViewer));      
        panelButton.add(previous);
        panelButton.add(next);
        return panelButton;
    }  
    
}
