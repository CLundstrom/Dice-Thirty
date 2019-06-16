package com.example.thirty.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thirty.R;

import java.util.ArrayList;

import controllers.GameController;


/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description:
 */
public class GameActivity extends AppCompatActivity {

    private GameController mGameController;
    private ArrayList<ImageView> mDiceViews;
    private Button roll;
    private TextView rollText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        roll = findViewById(R.id.button_roll);
        rollText = findViewById(R.id.rolls);
        roll.setOnClickListener( d -> {
            mGameController.refreshScene(this, rollText);
        });

        mDiceViews = getDiceViews();
        mGameController = new GameController(mDiceViews);
    }

    /**
     * Fetches ImageViews from the Scene which are later manipulated by GameController.
     * @return
     */
    private ArrayList<ImageView> getDiceViews(){
            ArrayList<ImageView> views = new ArrayList<>();
            views.add((ImageView) findViewById(R.id.dice1));
            views.add((ImageView) findViewById(R.id.dice2));
            views.add((ImageView) findViewById(R.id.dice3));
            views.add((ImageView) findViewById(R.id.dice4));
            views.add((ImageView) findViewById(R.id.dice5));
            views.add((ImageView) findViewById(R.id.dice6));
            return views;
    }
}
