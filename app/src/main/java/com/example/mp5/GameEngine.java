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
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(),
                backgroundImage.getX(), backgroundImage.getY(), null);
        if (backgroundImage.getX() < (AppConstants.SCREEN_WIDTH
                - AppConstants.getBitmapBank().getBackgroundWidth())) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(),
                    backgroundImage.getX() + AppConstants.getBitmapBank().getBackgroundWidth(),
                    backgroundImage.getY(), null);
        }
    }
}
