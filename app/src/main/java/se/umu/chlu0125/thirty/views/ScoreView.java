package se.umu.chlu0125.thirty.views;
import android.widget.TextView;

import se.umu.chlu0125.thirty.models.Score;

/**
 * Author: Christoffer Lundstrom
 * Date: 20/06/2019
 * <p>
 * Description: Handles the display of current Score when given a TextView and a Score.
 */
public class ScoreView  {

    TextView mTextView;

    public ScoreView(TextView textView){
        mTextView = textView;
        setDefaultScoreView();
    }

    /**
     * Updates the TextView with a provided Score.
     * @param score Score-object to be provided.
     */
    public void setScoreView(Score score){
        this.mTextView.setText("Points: " + score.getScore());
    }

    /**
     * Sets the default point text without a Score.
     */
    public void setDefaultScoreView(){
        this.mTextView.setText("Points: ");
    }




}
