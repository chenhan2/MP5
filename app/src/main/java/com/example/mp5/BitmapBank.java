package com.example.mp5;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] geoff;
    Bitmap tubeTop, tubeBottom;
    public BitmapBank(Resources resource) {
        background = BitmapFactory.decodeResource(resource, R.drawable.background);
        background = scaleImage(background);
        geoff = new Bitmap[4];
        geoff[0] = BitmapFactory.decodeResource(resource, R.drawable.geof);
        geoff[1] = BitmapFactory.decodeResource(resource, R.drawable.geof);
        geoff[2] = BitmapFactory.decodeResource(resource, R.drawable.geof);
        geoff[3] = BitmapFactory.decodeResource(resource, R.drawable.geof);
        tubeTop = BitmapFactory.decodeResource(resource, R.drawable.tube_top);
        tubeBottom = BitmapFactory.decodeResource(resource, R.drawable.tube_bottom);
    }

    //Return Tube-Top bitmap
    public Bitmap getTubeTop() {
        return tubeTop;
    }

    //Return Tube-Bottom Bitmap
    public Bitmap getTubeBottom() {
        return tubeBottom;
    }

    //return tubr-width
    public int getTubeWidth() {
        return tubeTop.getWidth();
    }

    //return tube-height
    public int getTubeHeight() {
        return tubeTop.getHeight();
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

    public Bitmap scaleImage(Bitmap bitmap) {
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap,
                backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}


