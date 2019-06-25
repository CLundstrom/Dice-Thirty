package controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.thirty.R;

import java.util.ArrayList;

import models.Game;
import models.Score;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description:
 */
public class ScoreActivity extends AppCompatActivity {

    private ArrayList<Score> mScoreList;
    TextView mScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mScoreText = findViewById(R.id.editText_scores);

        Intent intent = getIntent();
        mScoreList = (ArrayList<Score>) intent.getExtras().getSerializable("ScoreList");
        Log.d("ACTIVITY", "SCOREACTIVITY");
        printScores();
    }

    private void printScores(){
        for(Score s : mScoreList){
            mScoreText.append(String.valueOf(s.getScore()+"\n"));
        }
    }
}
