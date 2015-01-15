package views.ui.interfaces;

import model.Image;

public interface ImageViewer {
    public void update();
    public Image getImage();
    public void setImage(Image image);
}
