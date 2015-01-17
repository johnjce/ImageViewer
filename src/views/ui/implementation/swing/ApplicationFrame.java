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
        JButton nextButton = new JButton("Next");
        JButton previousButton = new JButton("Previous");
        addListeners(previousButton, nextButton);
        panelButton.add(previousButton);
        panelButton.add(nextButton);
        return panelButton;
    }
    
    private void addListeners (JButton previousButton, JButton nextButton) {
        previousButton.addActionListener(new PreviousImageCommand(imageViewer)); 
        nextButton.addActionListener(new NextImageCommand(imageViewer));
    }
    
}
