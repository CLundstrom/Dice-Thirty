package controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thirty.R;
import com.example.thirty.Views.ScoreView;

import java.util.ArrayList;

import controllers.GameController;
import models.Score;


/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Represents the Screen viewed after initating a New Game.
 */
public class GameActivity extends AppCompatActivity {

    private GameController mGameController;
    private ArrayList<ImageView> mDiceViews;
    private Button roll;
    private TextView rollText;
    private Spinner spinner;
    private ScoreView mScoreView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        roll = findViewById(R.id.button_roll);
        rollText = findViewById(R.id.rolls);
        spinner = findViewById(R.id.spinner);
        mScoreView = new ScoreView(findViewById(R.id.score_view));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.score_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
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
