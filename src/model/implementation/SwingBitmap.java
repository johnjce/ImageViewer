package model.implementation;

import model.Bitmap;

public class SwingBitmap implements Bitmap {

    private int [] pixels;
    
    public SwingBitmap (int [] pixels) {
        this.pixels=pixels;
    }
    
    @Override
    public int[] getPixels() {
        return this.pixels;
    }
    
}