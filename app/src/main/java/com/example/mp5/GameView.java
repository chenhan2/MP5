package com.example.mp5;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.os.Handler;
import android.view.Display;
import android.graphics.Point;
import android.widget.Button;


public class GameView extends View {

    // This is our custom View class
    Handler handler; // This is required to schedule a runnable after some delay
    Runnable runnable;
    final int UPDATE_MILLIS = 30;
    Bitmap background;
    Bitmap topTube, bottemTube;
    Display display;
    Point point;
    int dWith, dHeight; // Device width and height
    Rect rect;
    Bitmap geof;
    int velocity = 0;
    int gravity = 3;
    int geofX, geofY;
    boolean gameState = false;
    int gap = 400; // distance between upper and lower tubes
    int minTubeOffset, maxTubeOffset;
    int numberOfTubes = 4;
    int distanceBetweenTubes;
    int tubeX;
    int topTubeY;

    public GameView(Context context) {
        super(context);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate(); // This will call onDraw
            }
        };
        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
        dWith = point.x;
        dHeight = point.y;
        rect = new Rect(0, 0, dWith, dHeight);
        geof = BitmapFactory.decodeResource(getResources(), R.drawable.geof);
        geofX = dWith / 2 - geof.getWidth() / 2;
        geofY = dHeight / 2 - geof.getHeight() / 2;
        distanceBetweenTubes = dWith * 3 / 4;
        minTubeOffset = gap / 2;
        maxTubeOffset = dHeight - minTubeOffset - gap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // We'll draw our view inside onDraw()
        // Draw the background on canvas
        canvas.drawBitmap(background, null, rect, null);

        if (gameState) {
            // geof will not come back to the screen once he falls to the bottom
            if (geofY < dHeight) {
                velocity += gravity;// the falling speed is increasing by the effect of gravity
                geofY += velocity;
            }
        }
        // Put Geof's handsome head at the center of the screen
        canvas.drawBitmap(geof, geofX, geofY, null);
        handler.postDelayed(runnable, UPDATE_MILLIS);
    }

    //Get touch event

    /**
     * On touch.
     * @param event
     * @return true if we have done with the touch event and no further event is required
     */
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) { // tap detected, then we want to move bird upward
            velocity = -30; // set the upward speed to 30
            gameState = true;
        }
        return true;
    }
}
