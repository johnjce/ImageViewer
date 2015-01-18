package views.ui.implementation.swing;

import control.Command;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private SwingImageViewer imageViewer;
    private JPanel panelButton;
    
    public ApplicationFrame () {
        super(" Image Viewer ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1280,835));
        setResizable(false);
        createWidget();
    }
    
    public void register (Command [] listeners) {
        ((JButton)panelButton.getComponent(0)).addActionListener(listeners[0]);
        ((JButton)panelButton.getComponent(1)).addActionListener(listeners[1]);
        listeners[0].setImageViewer(imageViewer);
        listeners[1].setImageViewer(imageViewer);
    }

    private void createWidget() {
        add(createImageViewer(), BorderLayout.CENTER);
        add(createPanelButtons(), BorderLayout.SOUTH);
    }

    private JPanel createImageViewer() {
        imageViewer = new SwingImageViewer();
        return imageViewer;
    }

    private JPanel createPanelButtons() {
        panelButton = new JPanel() {
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.clearRect(0, 0, this.getWidth(), this.getHeight());
            }
            
        };
        JButton nextButton = new JButton("NEXT");
        JButton previousButton = new JButton("PREVIOUS");
        panelButton.add(previousButton);
        panelButton.add(nextButton);
        return panelButton;
    }
    
}
