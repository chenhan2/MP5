package com.example.mp5;

import android.graphics.Canvas;

public class GameEngine {

    BackgroundImage backgroundImage;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if (backgroundImage.getX() < - AppConstants.getBitmapBank().getBackgroundWidth()) {
            backgroundImage.setX(0);
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(),
                    backgroundImage.getX(), backgroundImage.getY(), null);
            
        }
    }
}
