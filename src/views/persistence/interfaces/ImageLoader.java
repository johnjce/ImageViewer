package views.persistence.interfaces;

import model.Image;

public interface ImageLoader {
    public Image load (String filename);
}
