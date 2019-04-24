package com.example.mp5;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.content.Context;
import android.os.Handler;
import android.view.Display;
import android.graphics.Point;


public class GameView extends View {

    // This is our custom View class
    Handler handler; // This is required to schedule a runnable after some delay
    Runnable runnable;
    final int UPDATE_MILLIS = 30;
    Bitmap background;
    Display display;
    Point point;
    int dWith, dHeight; // Device width and height
    Rect rect;
    Bitmap geof;
    int velocity = 0;
    int gravtiy = 10;
    int geofX, geofY;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // We'll draw our view inside onDraw()
        // Draw the background on canvas
        canvas.drawBitmap(background, null, rect, null);
        // Put Geof's handsome head at the center of the screen
        canvas.drawBitmap(geof, dWith / 2 - geof.getWidth() / 2,
                dHeight / 2 - geof.getHeight() / 2, null);
        handler.postDelayed(runnable, UPDATE_MILLIS);

    }
}
