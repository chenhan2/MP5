package com.example.mp5;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] geoff;
    public BitmapBank(Resources resource) {
        background = BitmapFactory.decodeResource(resource, R.drawable.background);
        background = scaleImage(background);
        geoff = new Bitmap[4];
        geoff[0] = BitmapFactory.decodeResource(resource, R.drawable.bird_frame1);
        geoff[1] = BitmapFactory.decodeResource(resource, R.drawable.bird_frame2);
        geoff[2] = BitmapFactory.decodeResource(resource, R.drawable.bird_frame3);
        geoff[3] = BitmapFactory.decodeResource(resource, R.drawable.bird_frame4);

    }

    //Return geoff bitmp of frame
    public Bitmap getGeoff(int frame) {
        return geoff[frame];
    }

    public int getGeoffWidth() {
        return geoff[0].getWidth();
    }

    public int getGeoffHeight() {
        return geoff[0].getHeight();
    }

    //Return background bitmap
    public Bitmap getBackground() {
        return background;
    }

    //Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }
}

