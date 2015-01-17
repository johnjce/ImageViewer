package model.implementation;

import model.Bitmap;
import model.Image;

public class RealImage implements Image {

    private Bitmap bitmap;
    
    public RealImage (Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    
    @Override
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    @Override
    public Image getNext() {
        System.out.println("asdas");
        return null;
    }

    @Override
    public Image getPrev() {
        System.out.println("asdas");
        return null;
    }
       
}
