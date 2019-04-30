package com.example.mp5;

public class Geoff {
    private int geoffX, geoffY, currentFrame, velocity;
    public static int maxFrame;
    public Geoff() {
        geoffX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getGeoffWidth()/2;
        geoffX = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getGeoffHeight()/2;
        currentFrame = 0;
        maxFrame = 3;
        velocity = 0;
    }

    // getter for velocity
    public int getVelocity() {
        return velocity;
    }

    // setter for v
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    //getter for frame
    public  int getCurrentFrame() {
        return currentFrame;
    }

    // setter
    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }
    
    //getter for getting x-coordinate of Geoff;
    public int getX() {
        return geoffX;
    }

    // getter for getting the Y-coordinate of geoff;
    public int getY() {
        return geoffY;
    }

    // setter for setting the X-coordinate;
    public void setX(int geoffX) {
        this.geoffX = geoffX;
    }

    //setter for setting the Y-coordinate;
    public void setY(int geoffY) {
        this.geoffY = geoffY;
    }
}
