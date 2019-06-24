package com.example.thirty.Views;
import android.widget.TextView;

import models.Score;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 20/06/2019
 * <p>
 * @Description: Handles the display of current Score when given a TextView and a Score.
 */
public class ScoreView {

    TextView mTextView;

    public ScoreView(TextView textView){
        mTextView = textView;
        updateView();
    }

    /**
     * Updates the TextView with a provided Score.
     * @param score Score-object to be provided.
     */
    public void updateViewWithScore(Score score){
        this.mTextView.setText("Points: " + score.getScore());
    }

    /**
     * Sets the default point text without a Score.
     */
    public void updateView(){
        this.mTextView.setText("Points: ");
    }




}
