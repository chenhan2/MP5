package com.example.mp5;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;
    Geoff geoff;
    static int gameState;
    ArrayList<Tube> tubes;
    Random random;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        geoff = new Geoff();
        // 0 = Not started
        //1 = Playing
        //2 = GameOver
        gameState = 0;
        tubes = new ArrayList<>();
        random = new Random();
        for(int i = 0; i< AppConstants.numberOfTubes; i++){
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTubes;
            // Get topTubeOffsetY
            int topTubeOffsetY = AppConstants.minTubeOffsetY +
                    random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
            // Now create Tube objects
            Tube tube = new Tube(tubeX, topTubeOffsetY);
            tubes.add(tube);
        }
    }

    public void updateAndDrawTubes(Canvas canvas){
        if(gameState == 1){
            for(int i=0; i< AppConstants.numberOfTubes; i++){
                if(tubes.get(i).getTubeX() < - AppConstants.getBitmapBank().getTubeWidth()){
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() +
                            AppConstants.numberOfTubes * AppConstants.distanceBetweenTubes);
                    int topTubeOffsetY = AppConstants.minTubeOffsetY +
                            random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
                    tubes.get(i).setTopTubeOffsetY(topTubeOffsetY);
                }
                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelocity);
                canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop(),tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
            }
        }
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if (backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
        if (backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
                    AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(), null);
        }
    }

    public void updateAndDrawBird(Canvas canvas) {
        if (gameState == 1) {
            if (geoff.getY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getGeoffHeight()) || geoff.getVelocity() < 0) {
                geoff.setVelocity(geoff.getVelocity() + AppConstants.gravity);
                geoff.setY(geoff.getY() + geoff.getVelocity());
            }
        }
        int currentFrame = geoff.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getGeoff(currentFrame), geoff.getX(), geoff.getY(), null);
        currentFrame++;
        // If it exceeds maxframe re-initialize to 0
        if (currentFrame > geoff.maxFrame) {
            currentFrame = 0;
        }
        geoff.setCurrentFrame(currentFrame);
    }
}
