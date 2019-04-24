package com.example.mp5;

import android.graphics.Canvas;
import android.view.View;
import android.content.Context;
import android.os.Handler;

public class GameView extends View {

    // This is our custom View class
    Handler handler; // This is required to schedule a runnable after some delay
    Runnable runnable;
    final int UPDATE_MILLIS = 30;

    public GameView(Context context) {
        super(context);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate(); // This will call onDraw
            }
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // We'll draw our view inside onDraw()

        handler.postDelayed(runnable, UPDATE_MILLIS);
    }
}
