package com.example.thirty.Views;
import android.widget.TextView;

import models.Score;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 20/06/2019
 * <p>
 * @Description: Handles the display of current Score when given a boundary.
 */
public class ScoreView {

    TextView mTextView;
    Score mCurrentScore;


    public ScoreView(TextView textView){
        mTextView = textView;
        updateView();
    }

    public void updateViewWithScore(Score score){
        this.mTextView.setText("Points: " + score.getScore());
    }

    public void updateView(){
        this.mTextView.setText("Points: ");
    }




}
