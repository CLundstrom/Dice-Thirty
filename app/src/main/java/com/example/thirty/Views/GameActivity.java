package com.example.thirty.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thirty.R;

import controllers.GameController;


/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description:
 */
public class GameActivity extends AppCompatActivity {

    GameController mGameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mGameController = new GameController();

    }


}
