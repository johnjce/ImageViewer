package model;

public class Image {
    
    private String nextImageName, previousImageName;
    private Image image;
    
    public String getNextImageName() {
        return nextImageName;
    }

    public String getPreviousImageName() {
        return previousImageName;
    }

    public Image getImage() {
        return image;
    }
    
}
