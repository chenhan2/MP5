package com.example.mp5;

public class BackgroundImage {
    private int backgroundImageX, backgroundImageY, backgroundImageVelocity;

    public BackgroundImage() {
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundImageVelocity = 3;
    }

    public int getX() {
        return backgroundImageX;
    }

    public int getY() {
        return backgroundImageY;
    }

    public void setX(int x) {
        backgroundImageX = x;
    }

    public void setY(int y) {
        backgroundImageY = y;
    }

    public int getVelocity() {
        return backgroundImageVelocity;
    }
}
