package controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.thirty.R;

import java.util.ArrayList;

import models.Score;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: The Activity which handles the final Score screen and displays the results.
 */
public class ScoreActivity extends AppCompatActivity {

    private final String STATE_SCOREACTIVITY = "STATE_SCOREACTIVITY";
    private ArrayList<Score> mScoreList;
    private TextView mScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null ){
            this.mScoreList = (ArrayList<Score>)savedInstanceState.getSerializable(STATE_SCOREACTIVITY);
        }
        else {
            // Get from previous Activity.
            Intent intent = getIntent();
            mScoreList = (ArrayList<Score>) intent.getExtras().getSerializable("ScoreList");
        }
        setContentView(R.layout.activity_score);

        // ViewItems
        Button buttonReplay = findViewById(R.id.replay);
        Button buttonMain = findViewById(R.id.button_mainmenu);
        mScoreText = findViewById(R.id.editText_scores);


        // Activity buttons
        buttonReplay.setOnClickListener(d -> startActivity(new Intent(this, GameActivity.class)));
        buttonMain.setOnClickListener(d -> startActivity(new Intent(this, MainActivity.class)));
        printScores();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putSerializable(STATE_SCOREACTIVITY, mScoreList);
        super.onSaveInstanceState(savedInstanceState);
    }



    /**
     * Fetches Score sent from GameActivity and prints the score-screen.
     */
    private void printScores(){


        int total = 0;
        mScoreList.sort((s1,s2) -> s1.getChoice().compareTo(s2.getChoice()));
        mScoreText.append("Choice.........Score\n\n");
        for(Score entry: mScoreList){
            total+= entry.getScore();
            mScoreText.append(entry.getChoice() + ".........." + entry.getScore()+"\n");
        }
        mScoreText.append("\n\nTotal Score: " + total);
    }
}
