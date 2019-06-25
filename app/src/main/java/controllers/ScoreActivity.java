package controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.thirty.R;

import java.util.ArrayList;

import models.Score;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description:
 */
public class ScoreActivity extends AppCompatActivity {

    private ArrayList<Score> mScoreList;
    private TextView mScoreText;
    private Button mButtonReplay;
    private Button mButtonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        // ViewItems
        mButtonReplay = findViewById(R.id.replay);
        mButtonMain = findViewById(R.id.button_mainmenu);
        mScoreText = findViewById(R.id.editText_scores);
        ////

        mButtonReplay.setOnClickListener(d -> {
            startActivity(new Intent(this, GameActivity.class));
        });

        mButtonMain.setOnClickListener(d -> {
            startActivity(new Intent(this, MainActivity.class));
        });


        Intent intent = getIntent();
        mScoreList = (ArrayList<Score>) intent.getExtras().getSerializable("ScoreList");
        Log.d("ACTIVITY", "SCOREACTIVITY");
        printScores();




    }

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
