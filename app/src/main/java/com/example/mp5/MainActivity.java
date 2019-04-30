package com.example.mp5;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppConstants.initialization(this.getApplicationContext());
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);
        finish();
    }
}
