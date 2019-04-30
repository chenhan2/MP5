package com.example.mp5;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class StartGame extends Activity {

    GameViewArchive gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameViewArchive(this);
        setContentView(gameView);

    }
}
