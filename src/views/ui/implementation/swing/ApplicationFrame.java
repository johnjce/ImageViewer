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
    
    public ApplicationFrame () {
        super(" Image Viewer ");
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createWidget();
        setVisible(true);
    }

    private void createWidget() {
        add(createImageViewer(), BorderLayout.SOUTH);
        add(createButtons(), BorderLayout.NORTH);
    }

    private JPanel createImageViewer() {
        imageViewer = new SwingImageViewer();
        return imageViewer;
    }

    private JPanel createButtons() {
        JPanel buttonPanel = new JPanel();     
        JButton next = new JButton("Next");
        next.addActionListener(new NextImageCommand());
        JButton previous = new JButton("Previous");
        previous.addActionListener(new PreviousImageCommand());      
        buttonPanel.add(next);
        buttonPanel.add(previous);
        return buttonPanel;
    }
}
