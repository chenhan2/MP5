package com.example.mp5;

import android.content.Context;

public class AppConstants {

    static BitmapBank bitmapBank;
    static GameEngine gameEngine;

    public static void initialization(Context context) {
        bitmapBank = new BitmapBank(context.getResources());
        gameEngine  = new GameEngine();

    }

    //Return BitmapBank instance
    public static BitmapBank getBitmapBank() {
        return bitmapBank;
    }

    //Return GameEngine instance
    public static GameEngine getGameEngine() {
        return gameEngine;
    }
}
