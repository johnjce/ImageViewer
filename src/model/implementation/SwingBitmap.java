package model.implementation;

import model.Bitmap;

public class SwingBitmap implements Bitmap {

    private byte [] pixels;
    
    public SwingBitmap (byte [] pixels) {
        this.pixels=pixels;
    }
    
    @Override
    public byte[] getPixels() {
        return this.pixels;
    }
    
}
